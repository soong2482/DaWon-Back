package hello.hellospring.carInfo.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import hello.hellospring.carInfo.domain.Car;
import hello.hellospring.carInfo.domain.Insert.*;
import hello.hellospring.carInfo.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminCarService {
    private final CarMapper carMapper;

    @Value("${custom.genFileDirPath}")
    private String uploadDir;

    public String insertMasterCar(AddCar addCar) {
        try {
            log.info("Inserting Master Car");
            Long carCode = carMapper.getCarCode() + 1;
            MasterCar masterCar = new MasterCar();
            masterCar.setCarCode(carCode);
            masterCar.setMasterCarName(addCar.getMasterCarName());
            masterCar.setMasterCarBrandName(addCar.getCarBrandName());
            masterCar.setMasterCarOrder(Long.parseLong(carMapper.getLastCarOrder())+1);
            masterCar.setMasterCarRecommend(false);
            carMapper.InsertMasterCar(masterCar);
            log.info("Inserted Master Car Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Master Car", e);
            return "Failed";
        }
    }



    public String insertPrice(Long carCode, AddCar addCar) {
        try {
            log.info("Inserting Price");
            CarPrice carPrice = new CarPrice();
            carPrice.setCarCode(carCode);
            carPrice.setCarRentPrice(addCar.getCarRentPrice());
            carPrice.setCarLeasePrice(addCar.getCarLeasePrice());
            carMapper.InsertPrice(carPrice);
            log.info("Inserted Price Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Price", e);
            return "Failed";
        }
    }

    public String insertImg(Long carCode, AddCar addCar,MultipartFile file) {
        try {
            log.info("Inserting Image");
            String imgName =UploadFile(file);
            CarImg carImg = new CarImg();
            carImg.setCarCode(carCode);
            carImg.setCarImg("/Car/"+imgName);
            carMapper.InsertImg(carImg);
            log.info("Inserted Image Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Image", e);
            return "Failed";
        }
    }

    public String insertDetail(Long carCode,AddCar addCar){
        try {
            log.info("Inserting Detail");
            CarDetail carDetail = new CarDetail();
            carDetail.setCar24Price(addCar.getCar24Price());
            carDetail.setCar48Price(addCar.getCar48Price());
            carDetail.setCarFuel(addCar.getCarFuel());
            carDetail.setCarMileage(addCar.getCarMileage());
            carDetail.setCarSort(addCar.getCarSort());
            carDetail.setCarCode(carCode);
            carDetail.setCarRealPrice(addCar.getCarRealPrice());
            carMapper.InsertDetail(carDetail);
            log.info("Inserted Detail Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to Detail", e);
            return "Failed";
        }
    }
    public String insertBrand(MultipartFile file,String masterCarBrandName) throws IOException{
        try{
            log.info("UploadFile-CarBrand");
            Path uploadPath = Paths.get(uploadDir + "/CarBrand");
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String extension = "";
            int dotIndex = file.getOriginalFilename().lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < file.getOriginalFilename().length() - 1) {
                extension = file.getOriginalFilename().substring(dotIndex);
            }
            String fileName = currentTime.format(formatter)+ "_" + extension;
            Path filePath = uploadPath.resolve(fileName);
            byte[] bytes = file.getBytes();
            Files.write(filePath, bytes);
            CarBrand carBrand = new CarBrand();
            carBrand.setCarBrandImg("/CarBrand/"+fileName);
            carBrand.setMasterCarBrandName(masterCarBrandName);
            carMapper.InsertBrand(carBrand);
            log.info("Inserted Brand Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Brand", e);
            return "Failed";
        }
    }
    private String UploadFile(MultipartFile file) throws IOException {
        try {
            log.info("UploadFile-Car");
            Path uploadPath = Paths.get(uploadDir + "/Car");
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String extension = "";
            int dotIndex = file.getOriginalFilename().lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < file.getOriginalFilename().length() - 1) {
                extension = file.getOriginalFilename().substring(dotIndex);
            }
            String fileName = currentTime.format(formatter) + "_" + extension;
            Path filePath = uploadPath.resolve(fileName);
            byte[] bytes = file.getBytes();
            Files.write(filePath, bytes);
            return fileName;
        } catch (IOException e) {
            log.error("Failed to upload Car file: {}", e.getMessage());
            return "UploadFailed";
        }
    }
    @Async
    public String insertCar(MultipartFile file, String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            AddCar addCar = objectMapper.readValue(json,AddCar.class);
            log.info("Inserting Car");
            String result = insertMasterCar(addCar);
            if (!result.equals("Success"))
                return result;

            Long carCode = carMapper.getCarCode();

            result = insertPrice(carCode, addCar);
            if (!result.equals("Success"))
                return result;

            result = insertImg(carCode, addCar ,file);
            if (!result.equals("Success"))
                return result;

            result = insertDetail(carCode,addCar);
            if (!result.equals("Success"))
                return result;

            log.info("Inserted Car Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Car", e);
            return "Failed";
        }
    }

    public String InsertTrim(CarTrim carTrim,String masterCarName) {
        try {
            log.info("Trim Insert.");
            carTrim.setCarTrimName(masterCarName+"_"+carTrim.getCarTrimName());
            carMapper.InsertTrim(carTrim);
            log.info("Insert Trim Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Trim", e);
            return "Failed";
        }
    }

    public String InsertOption(CarOption carOption) {
        try {
            log.info("carOption Insert.");
            carMapper.InsertOption(carOption);
            log.info("Insert carOption Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert carOption", e);
            return "Failed";
        }
    }

    public String UpdateCarOrder(Long CarCode, String CarOrder, String ChangeCarOrder) {
        try {
            log.info("updateCarOrder Update.");
            Long SecondCarCode = carMapper.getCarCodeFromOrder(ChangeCarOrder);
            carMapper.UpdateCarOrder(CarCode, ChangeCarOrder);
            carMapper.UpdateCarOrder(SecondCarCode, CarOrder);
            log.info("updateCarOrder Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to update Car Order", e);
            return "Failed";
        }
    }

    public String UpdateRecommendCar(Long CarCode) {
        try {
            log.info("updateRecommendCar Update.");
            carMapper.UpdateRecommendCar(CarCode);
            log.info("updateRecommendCar Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to update Recommend Car", e);
            return "Failed";
        }
    }

    public String UpdateCarPrice(Long CarCode, String CarPrice) {
        try {
            log.info("UpdateCarPrice Update.");
            carMapper.UpdateCarPrice(CarCode, CarPrice);
            log.info("UpdateCarPrice Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to update Car Price", e);
            return "Failed";
        }
    }

    public String CarDelete(Long CarCode) {
        try {
            log.info("CarDelete Delete.");
            carMapper.CarDelete(CarCode);
            log.info("CarDelete Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to delete Car", e);
            return "Failed";
        }
    }

    public String CarTrimDelete(Long CarCode, String CarTrimName) {
        try {
            log.info("CarTrim Delete.");
            carMapper.CarTrimDelete(CarCode, CarTrimName);
            log.info("CarTrimDelete Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to delete Car Trim", e);
            return "Failed";
        }
    }
    public String CarBrandDelete(String masterCarBrandName) {
        try {
            log.info("CarBrand Delete.");
            carMapper.CarBrandDelete(masterCarBrandName);
            log.info("CarBrandDelete Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to delete Car Brand", e);
            return "Failed";
        }
    }

    public String CarOptionDelete(Long CarCode, String CarOption) {
        try {
            log.info("CarOptionDelete Delete.");
            carMapper.CarOptionDelete(CarCode, CarOption);
            log.info("CarOptionDelete Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to delete Car Option", e);
            return "Failed";
        }
    }
    public String CarTrimPriceChange(String TrimName,String ChangeValueTrim){
        try{
            log.info("CarTrimPriceChange Change."+TrimName+"for price"+ChangeValueTrim);
            carMapper.CarTrimPriceChange(TrimName,ChangeValueTrim);
            log.info("CarTrimPriceChange Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to Change Car Trim Price", e);
            return "Failed";
        }
    }
    public String CarOptionPriceChange(String OptionName,String ChangeValueOption){
        try{
            log.info("CarOptionPriceChange Change."+OptionName+"for price"+ChangeValueOption);
            carMapper.CarOptionPriceChange(OptionName,ChangeValueOption);
            log.info("CarOptionPriceChange Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to Change Car Option Price", e);
            return "Failed";
        }
    }
    public String CarLeasePriceChange(Long CarCode,String ChangeValueLeasePrice){
        try{
            log.info("CarLeasePriceChange Change."+CarCode+"for price"+ChangeValueLeasePrice);
            carMapper.CarLeasePriceChange(CarCode,ChangeValueLeasePrice);
            log.info("CarLeasePriceChange Success");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to Change Car Lease Price", e);
            return "Failed";
        }
    }
    public String CarDetailChange(CarDetail carDetail){
        try{
            log.info("CarDetailChange Change");
            carMapper.CarDetailChange(carDetail);
            log.info("CarDetailChange Success");
            return "Success";
        }catch (Exception e) {
            log.error("Failed to CarDetailChange", e);
            return "Failed";
        }

    }
}

package hello.hellospring.carInfo.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import hello.hellospring.carInfo.domain.Car;
import hello.hellospring.carInfo.domain.Insert.*;
import hello.hellospring.carInfo.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminCarService {
    private final CarMapper carMapper;

    public String insertMasterCar(AddCar addCar) {
        try {
            log.info("Inserting Master Car");
            Long carCode = carMapper.getCarCode() + 1;
            MasterCar masterCar = new MasterCar();
            masterCar.setCarCode(carCode);
            masterCar.setMasterCarName(addCar.getMasterCarName());
            masterCar.setMasterCarOrder(carMapper.getLastCarOrder() + 1);
            masterCar.setMasterCarRecommend(false);
            carMapper.InsertMasterCar(masterCar);
            log.info("Inserted Master Car Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Master Car", e);
            return "Failed";
        }
    }

    public String insertTr(Long carCode) {
        try {
            log.info("Inserting Trim");
            CarTrim carTrim = new CarTrim();
            carTrim.setCarCode(carCode);
            carTrim.setCarTrimName("NORMAL");
            carTrim.setCarTrimPrice("0");
            carMapper.InsertTrim(carTrim);
            log.info("Inserted Trim Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Trim", e);
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

    public String insertImg(Long carCode, AddCar addCar) {
        try {
            log.info("Inserting Image");
            CarImg carImg = new CarImg();
            carImg.setCarCode(carCode);
            carImg.setCarImg(addCar.getCarImg());
            carImg.setCarBrandImg(addCar.getCarBrandImg());
            carMapper.InsertImg(carImg);
            log.info("Inserted Image Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Image", e);
            return "Failed";
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
            result = insertTr(carCode);
            if (!result.equals("Success"))
                return result;

            result = insertPrice(carCode, addCar);
            if (!result.equals("Success"))
                return result;

            result = insertImg(carCode, addCar);
            if (!result.equals("Success"))
                return result;

            log.info("Inserted Car Successfully");
            return "Success";
        } catch (Exception e) {
            log.error("Failed to insert Car", e);
            return "Failed";
        }
    }

    public String InsertTrim(CarTrim carTrim) {
        try {
            log.info("Trim Insert.");
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
}

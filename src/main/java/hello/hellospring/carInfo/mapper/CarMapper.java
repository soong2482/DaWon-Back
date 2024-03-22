package hello.hellospring.carInfo.mapper;
import hello.hellospring.carInfo.domain.Insert.*;
import hello.hellospring.carInfo.domain.Select.CarList;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarMapper {


    Long getCarCode();
    Long getCarCodeFromOrder(String ChangeCarOrder);
    String getLastCarOrder();
    void InsertMasterCar(MasterCar masterCar);
    void InsertTrim(CarTrim carTrim);
    void InsertPrice(CarPrice carPrice);
    void InsertImg(CarImg carImg);
    void InsertOption(CarOption carOption);
    void InsertBrand(CarBrand carBrand);

    List<CarList> HomeListCar();
    List<CarOption> CarOption(Long carCode,String carTrimName);
    List<CarTrim> CarTrim(Long carCode);
    List<CarList> RecommendListCar();
    List<CarBrand> BrandList();

    void UpdateCarOrder(Long carCode,String carOrder);
    void UpdateRecommendCar(Long carCode);
    void UpdateCarPrice(Long carCode,String carPrice);
    void CarTrimPriceChange(String trimName,String changeValueTrim);
    void CarOptionPriceChange(String optionName,String changeValueOption);
    void CarLeasePriceChange(Long carCode,String changeValueLeasePrice);

    void CarDelete(Long carCode);
    void CarTrimDelete(Long carCode,String carTrimName);
    void CarOptionDelete(Long carCode,String carOption);
    void CarBrandDelete(String masterCarBrandName);
}

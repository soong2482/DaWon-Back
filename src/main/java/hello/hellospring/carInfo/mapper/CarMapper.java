package hello.hellospring.carInfo.mapper;

import hello.hellospring.carInfo.domain.CarList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarMapper {

    List<CarList> HomeListCar();

}

package hello.hellospring.Mapper;

import hello.hellospring.Domain.Car.CarList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarMapper {

    List<CarList> HomeListCar();

}

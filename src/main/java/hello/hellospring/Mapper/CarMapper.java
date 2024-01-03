package hello.hellospring.Mapper;

import hello.hellospring.Domain.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarMapper {

    List<Car> listCar();

}

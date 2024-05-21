package hello.hellospring.loginInfo.mapper;

import hello.hellospring.loginInfo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
   String FindById(String username);
   User FindByPassword(String username);
}

package com.kuang.mapper;

import com.kuang.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
/*1：@Mapper注解的作用
- 从mybatis3.4.0开始加入了@Mapper注解，目的就是为了不再写mapper映射文件。
- 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类。@Mapper就是告诉spring这是你指定的mapper。并将这个类交给spring管理。
- 自动为这个接口生成一个实现类，让别的类进行引用。
*/
@Repository
public interface UsersMapper {
    List<Users> queryUserList();
    Users queryUserById(int id);
    int addUser(Users user);
    int updateUser(Users user);
    int deleteUser(int id);
}

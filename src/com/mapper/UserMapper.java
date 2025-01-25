package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.User;
public interface UserMapper {
    //添加
    public int insert(User user);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public User get(int id);  
    //修改
    public int update(User user);   
     //列表
    public List<User> list(@Param("where") String where);
    //分页
    public List<User> sealist(@Param("where") String where);
    //统计
    public int total(); 
}
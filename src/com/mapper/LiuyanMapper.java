package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Liuyan;
public interface LiuyanMapper {
    //添加
    public int insert(Liuyan liuyan);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Liuyan get(int id);  
    //修改
    public int update(Liuyan liuyan);   
     //列表
    public List<Liuyan> list(@Param("where") String where);
    //分页
    public List<Liuyan> sealist(@Param("where") String where);
    //统计
    public int total(); 
	
}
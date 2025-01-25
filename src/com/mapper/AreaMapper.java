package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Area;
public interface AreaMapper {
    //添加
    public int insert(Area area);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Area get(int id);  
    //修改
    public int update(Area area);   
     //列表
    public List<Area> list(@Param("where") String where);
    //分页
    public List<Area> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}
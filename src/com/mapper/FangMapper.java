package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Fang;
public interface FangMapper {
    //添加
    public int insert(Fang fang);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Fang get(int id);  
    //根据条件提取数据
	  public Fang getsql(@Param("where") String where);  
    //修改
    public int update(Fang fang);   
     //列表
    public List<Fang> list(@Param("where") String where);
    //分页
    public List<Fang> sealist(@Param("where") String where);
    //统计
    public int total(@Param("where") String where); 
public void updatesql(@Param("value") String value);
   public void deletesql(@Param("value") String value);
	
}
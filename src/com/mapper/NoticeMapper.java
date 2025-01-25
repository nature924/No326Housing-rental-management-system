package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Notice;
public interface NoticeMapper {
    //添加
    public int insert(Notice notice);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Notice get(int id);  
    //修改
    public int update(Notice notice);   
     //列表
    public List<Notice> list(@Param("where") String where);
    //分页
    public List<Notice> sealist(@Param("where") String where);
    //统计
    public int total(); 
	
}
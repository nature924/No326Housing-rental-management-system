package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Area;
import com.mapper.AreaMapper;
@Service
public class AreaService{
	@Autowired
	AreaMapper areaMapper;
	
	public List<Area> list(String where){
		return areaMapper.list(where);
	}
	public List<Area> sealist(String where) {
		// TODO Auto-generated method stub
		return areaMapper.sealist(where);
	}

	public int total() {
		return areaMapper.total();
	}

	
	public void insert(Area c) {
		areaMapper.insert(c);
		
	}


	public void update(Area c) {
		areaMapper.update(c);
	}


	public void delete(Area c) {
		areaMapper.delete(c.getId());
	}


	public Area get(int id) {
		// TODO Auto-generated method stub
		return areaMapper.get(id);
	}

   public void updatesql(String value) {
		areaMapper.updatesql(value);
	}
	public void deletesql(String value) {
		areaMapper.deletesql(value);
	}
}
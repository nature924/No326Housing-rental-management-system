package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Huser;
import com.mapper.HuserMapper;
@Service
public class HuserService{
	@Autowired
	HuserMapper huserMapper;
	
	public List<Huser> list(String where){
		return huserMapper.list(where);
	}
	public List<Huser> sealist(String where) {
		// TODO Auto-generated method stub
		return huserMapper.sealist(where);
	}
	public int total(String where) {
		return huserMapper.total(where);
	}

	public void insert(Huser c) {
		huserMapper.insert(c);
		
	}
	public void update(Huser c) {
		huserMapper.update(c);
	}


	public void delete(Huser c) {
		huserMapper.delete(c.getId());
	}


	public Huser get(int id) {
		// TODO Auto-generated method stub
		return huserMapper.get(id);
	}
public Huser getsql(String where) {
		return huserMapper.getsql(where);
	}
   public void updatesql(String value) {
		huserMapper.updatesql(value);
	}
	public void deletesql(String value) {
		huserMapper.deletesql(value);
	}
}
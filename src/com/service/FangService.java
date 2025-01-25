package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Fang;
import com.mapper.FangMapper;
@Service
public class FangService{
	@Autowired
	FangMapper fangMapper;
	
	public List<Fang> list(String where){
		return fangMapper.list(where);
	}
	public List<Fang> sealist(String where) {
		// TODO Auto-generated method stub
		return fangMapper.sealist(where);
	}
	public int total(String where) {
		return fangMapper.total(where);
	}

	public void insert(Fang c) {
		fangMapper.insert(c);
		
	}
	public void update(Fang c) {
		fangMapper.update(c);
	}


	public void delete(Fang c) {
		fangMapper.delete(c.getId());
	}


	public Fang get(int id) {
		// TODO Auto-generated method stub
		return fangMapper.get(id);
	}
public Fang getsql(String where) {
		return fangMapper.getsql(where);
	}
   public void updatesql(String value) {
		fangMapper.updatesql(value);
	}
	public void deletesql(String value) {
		fangMapper.deletesql(value);
	}
}
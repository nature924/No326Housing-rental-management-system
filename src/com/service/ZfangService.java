package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Zfang;
import com.mapper.ZfangMapper;
@Service
public class ZfangService{
	@Autowired
	ZfangMapper zfangMapper;
	
	public List<Zfang> list(String where){
		return zfangMapper.list(where);
	}
	public List<Zfang> sealist(String where) {
		// TODO Auto-generated method stub
		return zfangMapper.sealist(where);
	}
	public int total(String where) {
		return zfangMapper.total(where);
	}

	public void insert(Zfang c) {
		zfangMapper.insert(c);
		
	}
	public void update(Zfang c) {
		zfangMapper.update(c);
	}


	public void delete(Zfang c) {
		zfangMapper.delete(c.getId());
	}


	public Zfang get(int id) {
		// TODO Auto-generated method stub
		return zfangMapper.get(id);
	}
public Zfang getsql(String where) {
		return zfangMapper.getsql(where);
	}
   public void updatesql(String value) {
		zfangMapper.updatesql(value);
	}
	public void deletesql(String value) {
		zfangMapper.deletesql(value);
	}
}
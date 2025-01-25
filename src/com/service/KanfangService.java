package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Kanfang;
import com.mapper.KanfangMapper;
@Service
public class KanfangService{
	@Autowired
	KanfangMapper kanfangMapper;
	
	public List<Kanfang> list(String where){
		return kanfangMapper.list(where);
	}
	public List<Kanfang> sealist(String where) {
		// TODO Auto-generated method stub
		return kanfangMapper.sealist(where);
	}
	public int total(String where) {
		return kanfangMapper.total(where);
	}

	public void insert(Kanfang c) {
		kanfangMapper.insert(c);
		
	}
	public void update(Kanfang c) {
		kanfangMapper.update(c);
	}


	public void delete(Kanfang c) {
		kanfangMapper.delete(c.getId());
	}


	public Kanfang get(int id) {
		// TODO Auto-generated method stub
		return kanfangMapper.get(id);
	}
public Kanfang getsql(String where) {
		return kanfangMapper.getsql(where);
	}
   public void updatesql(String value) {
		kanfangMapper.updatesql(value);
	}
	public void deletesql(String value) {
		kanfangMapper.deletesql(value);
	}
}
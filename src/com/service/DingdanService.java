package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Dingdan;
import com.mapper.DingdanMapper;
@Service
public class DingdanService{
	@Autowired
	DingdanMapper dingdanMapper;
	
	public List<Dingdan> list(String where){
		return dingdanMapper.list(where);
	}
	public List<Dingdan> sealist(String where) {
		// TODO Auto-generated method stub
		return dingdanMapper.sealist(where);
	}
	public int total(String where) {
		return dingdanMapper.total(where);
	}

	public void insert(Dingdan c) {
		dingdanMapper.insert(c);
		
	}
	public void update(Dingdan c) {
		dingdanMapper.update(c);
	}


	public void delete(Dingdan c) {
		dingdanMapper.delete(c.getId());
	}


	public Dingdan get(int id) {
		// TODO Auto-generated method stub
		return dingdanMapper.get(id);
	}
public Dingdan getsql(String where) {
		return dingdanMapper.getsql(where);
	}
   public void updatesql(String value) {
		dingdanMapper.updatesql(value);
	}
	public void deletesql(String value) {
		dingdanMapper.deletesql(value);
	}
}
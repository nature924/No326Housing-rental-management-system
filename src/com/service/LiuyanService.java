package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Liuyan;
import com.mapper.LiuyanMapper;
@Service
public class LiuyanService{
	@Autowired
	LiuyanMapper liuyanMapper;
	
	public List<Liuyan> list(String where){
		return liuyanMapper.list(where);
	}
	public List<Liuyan> sealist(String where) {
		// TODO Auto-generated method stub
		return liuyanMapper.list(where);
	}

	public int total() {
		return liuyanMapper.total();
	}

	
	public void insert(Liuyan c) {
		liuyanMapper.insert(c);
		
	}


	public void update(Liuyan c) {
		liuyanMapper.update(c);
	}


	public void delete(Liuyan c) {
		liuyanMapper.delete(c.getId());
	}


	public Liuyan get(int id) {
		// TODO Auto-generated method stub
		return liuyanMapper.get(id);
	}


}
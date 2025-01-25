package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Admin;
import com.mapper.AdminMapper;
@Service
public class AdminService{
	@Autowired
	AdminMapper adminMapper;
	
	public List<Admin> list(String where){
		return adminMapper.list(where);
	}
	public List<Admin> sealist(String where) {
		// TODO Auto-generated method stub
		return adminMapper.list(where);
	}

	public int total() {
		return adminMapper.total();
	}

	
	public void insert(Admin c) {
		adminMapper.insert(c);
		
	}


	public void update(Admin c) {
		adminMapper.update(c);
	}


	public void delete(Admin c) {
		adminMapper.delete(c.getId());
	}


	public Admin get(int id) {
		// TODO Auto-generated method stub
		return adminMapper.get(id);
	}

}
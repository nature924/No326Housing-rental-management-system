package com.entity;

public class Admin {
		private Integer id;
	private String adminname;
	private String pwd;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getAdminname()
	{
		return adminname;
	}
	public void setAdminname(String adminname)
	{
		this.adminname = adminname;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	@Override

	public String toString() {

		return "Admin [id=" + id + ", adminname=" + adminname + ", pwd=" + pwd + "]";

	}
}
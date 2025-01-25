package com.entity;

public class Liuyan {
		private Integer id;
	private String title;
	private String neirong;
	private String huifu;
	private String uname;
	private String addtime;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getNeirong()
	{
		return neirong;
	}
	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}
	
	public String getHuifu()
	{
		return huifu;
	}
	public void setHuifu(String huifu)
	{
		this.huifu = huifu;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	
	public String getAddtime()
	{
		return addtime;
	}
	public void setAddtime(String addtime)
	{
		this.addtime = addtime;
	}
	@Override

	public String toString() {

		return "Liuyan [id=" + id + ", title=" + title + ", neirong=" + neirong + ", huifu=" + huifu + ", uname=" + uname + ", addtime=" + addtime + "]";

	}
}
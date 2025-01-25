package com.entity;

public class Notice {
		private Integer id;
	private String title;
	private String pic;
	private String neirong;
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
	
	public String getPic()
	{
		return pic;
	}
	public void setPic(String pic)
	{
		this.pic = pic;
	}
	
	public String getNeirong()
	{
		return neirong;
	}
	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
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

		return "Notice [id=" + id + ", title=" + title + ", pic=" + pic + ", neirong=" + neirong + ", addtime=" + addtime + "]";

	}
}
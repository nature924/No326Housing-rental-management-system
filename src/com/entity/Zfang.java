package com.entity;

public class Zfang {
		private Integer id;
	private String name;
	private String pic;
	private String addr;
	private String mianji;
	private String louceng;
	private String chaoxiang;
	private String jiaju;
	private String jiage;
	private String tel;
	private String jieshao;
	private String stime;
	private String zt;
	private String uname;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPic()
	{
		return pic;
	}
	public void setPic(String pic)
	{
		this.pic = pic;
	}
	
	public String getAddr()
	{
		return addr;
	}
	public void setAddr(String addr)
	{
		this.addr = addr;
	}
	
	public String getMianji()
	{
		return mianji;
	}
	public void setMianji(String mianji)
	{
		this.mianji = mianji;
	}
	
	public String getLouceng()
	{
		return louceng;
	}
	public void setLouceng(String louceng)
	{
		this.louceng = louceng;
	}
	
	public String getChaoxiang()
	{
		return chaoxiang;
	}
	public void setChaoxiang(String chaoxiang)
	{
		this.chaoxiang = chaoxiang;
	}
	
	public String getJiaju()
	{
		return jiaju;
	}
	public void setJiaju(String jiaju)
	{
		this.jiaju = jiaju;
	}
	
	public String getJiage()
	{
		return jiage;
	}
	public void setJiage(String jiage)
	{
		this.jiage = jiage;
	}
	
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	public String getJieshao()
	{
		return jieshao;
	}
	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}
	
	public String getStime()
	{
		return stime;
	}
	public void setStime(String stime)
	{
		this.stime = stime;
	}
	
	public String getZt()
	{
		return zt;
	}
	public void setZt(String zt)
	{
		this.zt = zt;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	@Override

	public String toString() {

		return "Zfang [id=" + id + ", name=" + name + ", pic=" + pic + ", addr=" + addr + ", mianji=" + mianji + ", louceng=" + louceng + ", chaoxiang=" + chaoxiang + ", jiaju=" + jiaju + ", jiage=" + jiage + ", tel=" + tel + ", jieshao=" + jieshao + ", stime=" + stime + ", zt=" + zt + ", uname=" + uname + "]";

	}
}
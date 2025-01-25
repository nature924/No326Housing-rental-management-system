package com.entity;

public class Dingdan {
		private Integer id;
	private Integer fang;
	private Fang fangfk;
	private String orderid;
	private String jiage;
	private String yajin;
	private String sdate;
	private String tel;
	private String beizhu;
	private String uname;
	private String sname;
	private String zt;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getFang()
	{
		return fang;
	}
	public void setFang(Integer fang)
	{
		this.fang = fang;
	}
	
	public Fang getFangfk() {
			return fangfk;
	}
	public void setFangfk(Fang fangfk) {
		this.fangfk = fangfk;
	}
	public String getOrderid()
	{
		return orderid;
	}
	public void setOrderid(String orderid)
	{
		this.orderid = orderid;
	}
	
	public String getJiage()
	{
		return jiage;
	}
	public void setJiage(String jiage)
	{
		this.jiage = jiage;
	}
	
	public String getYajin()
	{
		return yajin;
	}
	public void setYajin(String yajin)
	{
		this.yajin = yajin;
	}
	
	public String getSdate()
	{
		return sdate;
	}
	public void setSdate(String sdate)
	{
		this.sdate = sdate;
	}
	
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	public String getBeizhu()
	{
		return beizhu;
	}
	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	
	public String getSname()
	{
		return sname;
	}
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	
	public String getZt()
	{
		return zt;
	}
	public void setZt(String zt)
	{
		this.zt = zt;
	}
	@Override

	public String toString() {

		return "Dingdan [id=" + id + ", fang=" + fang + ", orderid=" + orderid + ", jiage=" + jiage + ", yajin=" + yajin + ", sdate=" + sdate + ", tel=" + tel + ", beizhu=" + beizhu + ", uname=" + uname + ", sname=" + sname + ", zt=" + zt + "]";

	}
}
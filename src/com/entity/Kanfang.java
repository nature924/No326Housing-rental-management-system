package com.entity;

public class Kanfang {
		private Integer id;
	private Integer zfang;
	private Zfang zfangfk;
	private String sdate;
	private String tel;
	private String beizhu;
	private String sname;
	private String uname;
	private String zt;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getZfang()
	{
		return zfang;
	}
	public void setZfang(Integer zfang)
	{
		this.zfang = zfang;
	}
	
	public Zfang getZfangfk() {
			return zfangfk;
	}
	public void setZfangfk(Zfang zfangfk) {
		this.zfangfk = zfangfk;
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
	
	public String getSname()
	{
		return sname;
	}
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
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

		return "Kanfang [id=" + id + ", zfang=" + zfang + ", sdate=" + sdate + ", tel=" + tel + ", beizhu=" + beizhu + ", sname=" + sname + ", uname=" + uname + ", zt=" + zt + "]";

	}
}
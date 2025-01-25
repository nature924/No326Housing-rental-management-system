package com.entity;

public class Fang {
		private Integer id;
	private String name;
	private String pic;
	private String area;
	private Area areafk;
	private String xiaoqu;
	private String chanquan;
	private String niandai;
	private String chaoxiang;
	private String zhuangxiu;
	private String mianji;
	private String jiage;
	private String dizhi;
	private String lianxiren;
	private String tel;
	private String gongjiao;
	private String uname;
	private String jieshao;
	private String addtime;
	private String zt;

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
	
	public String getArea()
	{
		return area;
	}
	public void setArea(String area)
	{
		this.area = area;
	}
	
	public Area getAreafk() {
			return areafk;
	}
	public void setAreafk(Area areafk) {
		this.areafk = areafk;
	}
	public String getXiaoqu()
	{
		return xiaoqu;
	}
	public void setXiaoqu(String xiaoqu)
	{
		this.xiaoqu = xiaoqu;
	}
	
	public String getChanquan()
	{
		return chanquan;
	}
	public void setChanquan(String chanquan)
	{
		this.chanquan = chanquan;
	}
	
	public String getNiandai()
	{
		return niandai;
	}
	public void setNiandai(String niandai)
	{
		this.niandai = niandai;
	}
	
	public String getChaoxiang()
	{
		return chaoxiang;
	}
	public void setChaoxiang(String chaoxiang)
	{
		this.chaoxiang = chaoxiang;
	}
	
	public String getZhuangxiu()
	{
		return zhuangxiu;
	}
	public void setZhuangxiu(String zhuangxiu)
	{
		this.zhuangxiu = zhuangxiu;
	}
	
	public String getMianji()
	{
		return mianji;
	}
	public void setMianji(String mianji)
	{
		this.mianji = mianji;
	}
	
	public String getJiage()
	{
		return jiage;
	}
	public void setJiage(String jiage)
	{
		this.jiage = jiage;
	}
	
	public String getDizhi()
	{
		return dizhi;
	}
	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}
	
	public String getLianxiren()
	{
		return lianxiren;
	}
	public void setLianxiren(String lianxiren)
	{
		this.lianxiren = lianxiren;
	}
	
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	public String getGongjiao()
	{
		return gongjiao;
	}
	public void setGongjiao(String gongjiao)
	{
		this.gongjiao = gongjiao;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	
	public String getJieshao()
	{
		return jieshao;
	}
	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}
	
	public String getAddtime()
	{
		return addtime;
	}
	public void setAddtime(String addtime)
	{
		this.addtime = addtime;
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

		return "Fang [id=" + id + ", name=" + name + ", pic=" + pic + ", area=" + area + ", xiaoqu=" + xiaoqu + ", chanquan=" + chanquan + ", niandai=" + niandai + ", chaoxiang=" + chaoxiang + ", zhuangxiu=" + zhuangxiu + ", mianji=" + mianji + ", jiage=" + jiage + ", dizhi=" + dizhi + ", lianxiren=" + lianxiren + ", tel=" + tel + ", gongjiao=" + gongjiao + ", uname=" + uname + ", jieshao=" + jieshao + ", addtime=" + addtime + ", zt=" + zt + "]";

	}
}
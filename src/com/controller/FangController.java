package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Fang;
import com.service.FangService;
import com.entity.Area;
import com.service.AreaService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class FangController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	FangService fangService;
	@Autowired
	AreaService areaService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("fangmy")
	public String listFangmy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("area")) && request.getParameter("area") !=null)
			w=w+ " and area  = '"+request.getParameter("area")+"'";

if (!"".equals(request.getParameter("xiaoqu")) && request.getParameter("xiaoqu") !=null)
w=w+ " and xiaoqu like '%"+request.getParameter("xiaoqu")+"%'";

if (!"".equals(request.getParameter("chanquan")) && request.getParameter("chanquan") !=null)
w=w+ " and chanquan like '%"+request.getParameter("chanquan")+"%'";

if (!"".equals(request.getParameter("niandai")) && request.getParameter("niandai") !=null)
w=w+ " and niandai like '%"+request.getParameter("niandai")+"%'";

if (!"".equals(request.getParameter("chaoxiang")) && request.getParameter("chaoxiang") !=null)
w=w+ " and chaoxiang like '%"+request.getParameter("chaoxiang")+"%'";

if (!"".equals(request.getParameter("zhuangxiu")) && request.getParameter("zhuangxiu") !=null)
w=w+ " and zhuangxiu like '%"+request.getParameter("zhuangxiu")+"%'";

if (!"".equals(request.getParameter("mianji")) && request.getParameter("mianji") !=null)
w=w+ " and mianji like '%"+request.getParameter("mianji")+"%'";

if (!"".equals(request.getParameter("lianxiren")) && request.getParameter("lianxiren") !=null)
w=w+ " and lianxiren like '%"+request.getParameter("lianxiren")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Fang> cs= fangService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Fang fang=(Fang)cs.get(i);
}
	List<Area> area= areaService.list("");
		// 放入转发参数
		model.addAttribute("area", area);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Fang> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/fang/fangmy";
	}
//房屋信息列表管理页面
	@RequestMapping("fanglist")
	public String listFang(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("area")) && request.getParameter("area") !=null)
			w=w+ " and area  = '"+request.getParameter("area")+"'";

if (!"".equals(request.getParameter("xiaoqu")) && request.getParameter("xiaoqu") !=null)
w=w+ " and xiaoqu like '%"+request.getParameter("xiaoqu")+"%'";

if (!"".equals(request.getParameter("chanquan")) && request.getParameter("chanquan") !=null)
w=w+ " and chanquan like '%"+request.getParameter("chanquan")+"%'";

if (!"".equals(request.getParameter("niandai")) && request.getParameter("niandai") !=null)
w=w+ " and niandai like '%"+request.getParameter("niandai")+"%'";

if (!"".equals(request.getParameter("chaoxiang")) && request.getParameter("chaoxiang") !=null)
w=w+ " and chaoxiang like '%"+request.getParameter("chaoxiang")+"%'";

if (!"".equals(request.getParameter("zhuangxiu")) && request.getParameter("zhuangxiu") !=null)
w=w+ " and zhuangxiu like '%"+request.getParameter("zhuangxiu")+"%'";

if (!"".equals(request.getParameter("mianji")) && request.getParameter("mianji") !=null)
w=w+ " and mianji like '%"+request.getParameter("mianji")+"%'";

if (!"".equals(request.getParameter("lianxiren")) && request.getParameter("lianxiren") !=null)
w=w+ " and lianxiren like '%"+request.getParameter("lianxiren")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Fang> cs= fangService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Fang fang=(Fang)cs.get(i);
}
	List<Area> area= areaService.list("");
		// 放入转发参数
		model.addAttribute("area", area);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Fang> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		
		return "pages/fang/fanglist";
	}

	@RequestMapping("fangadd")
	public String addfang(Model model){
	List<Area> area= areaService.list("");
		// 放入转发参数
		model.addAttribute("area", area);

	return "pages/fang/fangadd";
	}
	//添加房屋信息数据
	@RequestMapping("fanginsert")
	public String insertFang(Fang fang,Model model){
	String forword=request.getParameter("forword");
		fangService.insert(fang);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除房屋信息数据
	@RequestMapping("fangdel")
	public String deleteFang(Fang fang,Model model){
		String forword=request.getParameter("forword");
		fangService.delete(fang);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的房屋信息数据
	@RequestMapping("fangedit")
	public String editFang(Model model,Fang fang){
		Fang c= fangService.get(fang.getId());
List<Area> area= areaService.list("");
		// 放入转发参数
		model.addAttribute("area", area);

		model.addAttribute("c", c);
		return "pages/fang/fangedit";
	}

	//修改的房屋信息数据
	@RequestMapping("fangupdate")
	public String updateFang(Fang fang,Model model){
		String forword=request.getParameter("forword");
		fangService.update(fang);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//房屋信息所有列表页
	@RequestMapping("fangAll")
	public String listFangAll(Model model){
		String w=" and zt='已审核'";


if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("area")) && request.getParameter("area") !=null)
			w=w+ " and area  = '"+request.getParameter("area")+"'";

if (!"".equals(request.getParameter("xiaoqu")) && request.getParameter("xiaoqu") !=null)
w=w+ " and xiaoqu like '%"+request.getParameter("xiaoqu")+"%'";

if (!"".equals(request.getParameter("chanquan")) && request.getParameter("chanquan") !=null)
w=w+ " and chanquan like '%"+request.getParameter("chanquan")+"%'";

if (!"".equals(request.getParameter("niandai")) && request.getParameter("niandai") !=null)
w=w+ " and niandai like '%"+request.getParameter("niandai")+"%'";

if (!"".equals(request.getParameter("chaoxiang")) && request.getParameter("chaoxiang") !=null)
w=w+ " and chaoxiang like '%"+request.getParameter("chaoxiang")+"%'";

if (!"".equals(request.getParameter("zhuangxiu")) && request.getParameter("zhuangxiu") !=null)
w=w+ " and zhuangxiu like '%"+request.getParameter("zhuangxiu")+"%'";

if (!"".equals(request.getParameter("mianji")) && request.getParameter("mianji") !=null)
w=w+ " and mianji like '%"+request.getParameter("mianji")+"%'";

if (!"".equals(request.getParameter("lianxiren")) && request.getParameter("lianxiren") !=null)
w=w+ " and lianxiren like '%"+request.getParameter("lianxiren")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Fang> cs= fangService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Fang fang=(Fang)cs.get(i);
}
	List<Area> area= areaService.list("");
		// 放入转发参数
		model.addAttribute("area", area);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Fang> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		return "pages/fang/fangAll";
	}

@RequestMapping("fangview")
public String viewFang(Model model,Fang fang){
Fang c= fangService.get(fang.getId());
model.addAttribute("c", c);
return "pages/fang/fangview";
}
}
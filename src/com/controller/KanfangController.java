package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Kanfang;
import com.service.KanfangService;
import com.entity.Zfang;
import com.service.ZfangService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class KanfangController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	KanfangService kanfangService;
	@Autowired
	ZfangService zfangService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("kanfangmy")
	public String listKanfangmy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("zfang")) && request.getParameter("zfang") !=null)
			w=w+ " and zfang  = "+request.getParameter("zfang")+"";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("sname")) && request.getParameter("sname") !=null)
w=w+ " and sname like '%"+request.getParameter("sname")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Kanfang> cs= kanfangService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Kanfang kanfang=(Kanfang)cs.get(i);
kanfang.setZfangfk(zfangService.get(kanfang.getZfang()));
}
	List<Zfang> zfang= zfangService.list("");
		// 放入转发参数
		model.addAttribute("zfang", zfang);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Kanfang> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/kanfang/kanfangmy";
	}
//预约看房列表管理页面
	@RequestMapping("kanfanglist")
	public String listKanfang(Model model){
String w="";

if (!"".equals(request.getParameter("zfang")) && request.getParameter("zfang") !=null)
			w=w+ " and zfang  = "+request.getParameter("zfang")+"";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("sname")) && request.getParameter("sname") !=null)
w=w+ " and sname like '%"+request.getParameter("sname")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Kanfang> cs= kanfangService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Kanfang kanfang=(Kanfang)cs.get(i);
kanfang.setZfangfk(zfangService.get(kanfang.getZfang()));
}
	List<Zfang> zfang= zfangService.list("");
		// 放入转发参数
		model.addAttribute("zfang", zfang);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Kanfang> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/kanfang/kanfanglist";
	}

	@RequestMapping("kanfangadd")
	public String addkanfang(Model model){
	List<Zfang> zfang= zfangService.list("");
		// 放入转发参数
		model.addAttribute("zfang", zfang);

	return "pages/kanfang/kanfangadd";
	}
	//添加预约看房数据
	@RequestMapping("kanfanginsert")
	public String insertKanfang(Kanfang kanfang,Model model){
	String forword=request.getParameter("forword");
		kanfangService.insert(kanfang);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除预约看房数据
	@RequestMapping("kanfangdel")
	public String deleteKanfang(Kanfang kanfang,Model model){
		String forword=request.getParameter("forword");
		kanfangService.delete(kanfang);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的预约看房数据
	@RequestMapping("kanfangedit")
	public String editKanfang(Model model,Kanfang kanfang){
		Kanfang c= kanfangService.get(kanfang.getId());
List<Zfang> zfang= zfangService.list("");
		// 放入转发参数
		model.addAttribute("zfang", zfang);

		model.addAttribute("c", c);
		return "pages/kanfang/kanfangedit";
	}

	//修改的预约看房数据
	@RequestMapping("kanfangupdate")
	public String updateKanfang(Kanfang kanfang,Model model){
		String forword=request.getParameter("forword");
		kanfangService.update(kanfang);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//预约看房所有列表页
	@RequestMapping("kanfangAll")
	public String listKanfangAll(Model model){
String w="";

if (!"".equals(request.getParameter("zfang")) && request.getParameter("zfang") !=null)
			w=w+ " and zfang  = "+request.getParameter("zfang")+"";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("sname")) && request.getParameter("sname") !=null)
w=w+ " and sname like '%"+request.getParameter("sname")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Kanfang> cs= kanfangService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Kanfang kanfang=(Kanfang)cs.get(i);
kanfang.setZfangfk(zfangService.get(kanfang.getZfang()));
}
	List<Zfang> zfang= zfangService.list("");
		// 放入转发参数
		model.addAttribute("zfang", zfang);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Kanfang> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/kanfang/kanfangAll";
	}
}
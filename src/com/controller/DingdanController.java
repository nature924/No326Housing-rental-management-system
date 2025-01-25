package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Dingdan;
import com.service.DingdanService;
import com.entity.Fang;
import com.service.FangService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class DingdanController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	DingdanService dingdanService;
	@Autowired
	FangService fangService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("dingdanmy")
	public String listDingdanmy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("fang")) && request.getParameter("fang") !=null)
			w=w+ " and fang  = "+request.getParameter("fang")+"";

if (!"".equals(request.getParameter("orderid")) && request.getParameter("orderid") !=null)
w=w+ " and orderid like '%"+request.getParameter("orderid")+"%'";

if (!"".equals(request.getParameter("yajin")) && request.getParameter("yajin") !=null)
w=w+ " and yajin like '%"+request.getParameter("yajin")+"%'";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("sname")) && request.getParameter("sname") !=null)
w=w+ " and sname like '%"+request.getParameter("sname")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Dingdan> cs= dingdanService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Dingdan dingdan=(Dingdan)cs.get(i);
dingdan.setFangfk(fangService.get(dingdan.getFang()));
}
	List<Fang> fang= fangService.list("");
		// 放入转发参数
		model.addAttribute("fang", fang);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Dingdan> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/dingdan/dingdanmy";
	}
//购房订单列表管理页面
	@RequestMapping("dingdanlist")
	public String listDingdan(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and sname='"+uname+"'";

if (!"".equals(request.getParameter("fang")) && request.getParameter("fang") !=null)
			w=w+ " and fang  = "+request.getParameter("fang")+"";

if (!"".equals(request.getParameter("orderid")) && request.getParameter("orderid") !=null)
w=w+ " and orderid like '%"+request.getParameter("orderid")+"%'";

if (!"".equals(request.getParameter("yajin")) && request.getParameter("yajin") !=null)
w=w+ " and yajin like '%"+request.getParameter("yajin")+"%'";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";



if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Dingdan> cs= dingdanService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Dingdan dingdan=(Dingdan)cs.get(i);
dingdan.setFangfk(fangService.get(dingdan.getFang()));
}
	List<Fang> fang= fangService.list("");
		// 放入转发参数
		model.addAttribute("fang", fang);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Dingdan> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/dingdan/dingdanlist";
	}

	@RequestMapping("dingdanadd")
	public String adddingdan(Model model){
	List<Fang> fang= fangService.list("");
		// 放入转发参数
		model.addAttribute("fang", fang);

	return "pages/dingdan/dingdanadd";
	}
	//添加购房订单数据
	@RequestMapping("dingdaninsert")
	public String insertDingdan(Dingdan dingdan,Model model){
	String forword=request.getParameter("forword");
		dingdanService.insert(dingdan);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除购房订单数据
	@RequestMapping("dingdandel")
	public String deleteDingdan(Dingdan dingdan,Model model){
		String forword=request.getParameter("forword");
		dingdanService.delete(dingdan);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的购房订单数据
	@RequestMapping("dingdanedit")
	public String editDingdan(Model model,Dingdan dingdan){
		Dingdan c= dingdanService.get(dingdan.getId());
List<Fang> fang= fangService.list("");
		// 放入转发参数
		model.addAttribute("fang", fang);

		model.addAttribute("c", c);
		return "pages/dingdan/dingdanedit";
	}

	//修改的购房订单数据
	@RequestMapping("dingdanupdate")
	public String updateDingdan(Dingdan dingdan,Model model){
		String forword=request.getParameter("forword");
		dingdanService.update(dingdan);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//购房订单所有列表页
	@RequestMapping("dingdanAll")
	public String listDingdanAll(Model model){
String w="";

if (!"".equals(request.getParameter("fang")) && request.getParameter("fang") !=null)
			w=w+ " and fang  = "+request.getParameter("fang")+"";

if (!"".equals(request.getParameter("orderid")) && request.getParameter("orderid") !=null)
w=w+ " and orderid like '%"+request.getParameter("orderid")+"%'";

if (!"".equals(request.getParameter("yajin")) && request.getParameter("yajin") !=null)
w=w+ " and yajin like '%"+request.getParameter("yajin")+"%'";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

if (!"".equals(request.getParameter("sname")) && request.getParameter("sname") !=null)
w=w+ " and sname like '%"+request.getParameter("sname")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Dingdan> cs= dingdanService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Dingdan dingdan=(Dingdan)cs.get(i);
dingdan.setFangfk(fangService.get(dingdan.getFang()));
}
	List<Fang> fang= fangService.list("");
		// 放入转发参数
		model.addAttribute("fang", fang);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Dingdan> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/dingdan/dingdanAll";
	}
}
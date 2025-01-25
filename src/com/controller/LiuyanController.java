package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Liuyan;
import com.service.LiuyanService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class LiuyanController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	LiuyanService liuyanService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("liuyanmy")
	public String listLiuyanmy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("title")) && request.getParameter("title") !=null)
w=w+ " and title like '%"+request.getParameter("title")+"%'";

if (!"".equals(request.getParameter("huifu")) && request.getParameter("huifu") !=null)
w=w+ " and huifu like '%"+request.getParameter("huifu")+"%'";

		List<Liuyan> cs= liuyanService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Liuyan liuyan=(Liuyan)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Liuyan> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/liuyan/liuyanmy";
	}
//列表管理页面
	@RequestMapping("liuyanlist")
	public String listLiuyan(Model model){
String w="";

if (!"".equals(request.getParameter("title")) && request.getParameter("title") !=null)
w=w+ " and title like '%"+request.getParameter("title")+"%'";

if (!"".equals(request.getParameter("huifu")) && request.getParameter("huifu") !=null)
w=w+ " and huifu like '%"+request.getParameter("huifu")+"%'";

		List<Liuyan> cs= liuyanService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Liuyan liuyan=(Liuyan)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Liuyan> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/liuyan/liuyanlist";
	}

	@RequestMapping("liuyanadd")
	public String addliuyan(Model model){

	return "pages/liuyan/liuyanadd";
	}
	//添加数据
	@RequestMapping("liuyaninsert")
	public String insertLiuyan(Liuyan liuyan,Model model){
	String forword=request.getParameter("forword");
		liuyanService.insert(liuyan);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除数据
	@RequestMapping("liuyandel")
	public String deleteLiuyan(Liuyan liuyan,Model model){
		String forword=request.getParameter("forword");
		liuyanService.delete(liuyan);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的数据
	@RequestMapping("liuyanedit")
	public String editLiuyan(Model model,Liuyan liuyan){
		Liuyan c= liuyanService.get(liuyan.getId());

		model.addAttribute("c", c);
		return "pages/liuyan/liuyanedit";
	}

	//修改的数据
	@RequestMapping("liuyanupdate")
	public String updateLiuyan(Liuyan liuyan,Model model){
		String forword=request.getParameter("forword");
		liuyanService.update(liuyan);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//所有列表页
	@RequestMapping("liuyanAll")
	public String listLiuyanAll(Model model){
String w="";

if (!"".equals(request.getParameter("title")) && request.getParameter("title") !=null)
w=w+ " and title like '%"+request.getParameter("title")+"%'";

if (!"".equals(request.getParameter("huifu")) && request.getParameter("huifu") !=null)
w=w+ " and huifu like '%"+request.getParameter("huifu")+"%'";

		List<Liuyan> cs= liuyanService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Liuyan liuyan=(Liuyan)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Liuyan> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/liuyan/liuyanAll";
	}

@RequestMapping("liuyanview")
public String viewLiuyan(Model model,Liuyan liuyan){
Liuyan c= liuyanService.get(liuyan.getId());
model.addAttribute("c", c);
return "pages/liuyan/liuyanview";
}
}
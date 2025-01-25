package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Zfang;
import com.service.ZfangService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class ZfangController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	ZfangService zfangService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("zfangmy")
	public String listZfangmy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("mianji")) && request.getParameter("mianji") !=null)
w=w+ " and mianji like '%"+request.getParameter("mianji")+"%'";

if (!"".equals(request.getParameter("louceng")) && request.getParameter("louceng") !=null)
w=w+ " and louceng like '%"+request.getParameter("louceng")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Zfang> cs= zfangService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Zfang zfang=(Zfang)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Zfang> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/zfang/zfangmy";
	}
//租房信息列表管理页面
	@RequestMapping("zfanglist")
	public String listZfang(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("mianji")) && request.getParameter("mianji") !=null)
w=w+ " and mianji like '%"+request.getParameter("mianji")+"%'";

if (!"".equals(request.getParameter("louceng")) && request.getParameter("louceng") !=null)
w=w+ " and louceng like '%"+request.getParameter("louceng")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Zfang> cs= zfangService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Zfang zfang=(Zfang)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Zfang> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/zfang/zfanglist";
	}

	@RequestMapping("zfangadd")
	public String addzfang(Model model){

	return "pages/zfang/zfangadd";
	}
	//添加租房信息数据
	@RequestMapping("zfanginsert")
	public String insertZfang(Zfang zfang,Model model){
	String forword=request.getParameter("forword");
		zfangService.insert(zfang);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除租房信息数据
	@RequestMapping("zfangdel")
	public String deleteZfang(Zfang zfang,Model model){
		String forword=request.getParameter("forword");
		zfangService.delete(zfang);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的租房信息数据
	@RequestMapping("zfangedit")
	public String editZfang(Model model,Zfang zfang){
		Zfang c= zfangService.get(zfang.getId());

		model.addAttribute("c", c);
		return "pages/zfang/zfangedit";
	}

	//修改的租房信息数据
	@RequestMapping("zfangupdate")
	public String updateZfang(Zfang zfang,Model model){
		String forword=request.getParameter("forword");
		zfangService.update(zfang);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//租房信息所有列表页
	@RequestMapping("zfangAll")
	public String listZfangAll(Model model){
String w=" and zt='已审核'";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("mianji")) && request.getParameter("mianji") !=null)
w=w+ " and mianji like '%"+request.getParameter("mianji")+"%'";

if (!"".equals(request.getParameter("louceng")) && request.getParameter("louceng") !=null)
w=w+ " and louceng like '%"+request.getParameter("louceng")+"%'";



		List<Zfang> cs= zfangService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Zfang zfang=(Zfang)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Zfang> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/zfang/zfangAll";
	}

@RequestMapping("zfangview")
public String viewZfang(Model model,Zfang zfang){
Zfang c= zfangService.get(zfang.getId());
model.addAttribute("c", c);
return "pages/zfang/zfangview";
}
}
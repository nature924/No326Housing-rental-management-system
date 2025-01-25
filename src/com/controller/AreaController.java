package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Area;
import com.service.AreaService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class AreaController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	AreaService areaService;
@Autowired
HttpServletRequest request;
//列表管理页面
	@RequestMapping("arealist")
	public String listArea(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Area> cs= areaService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Area area=(Area)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Area> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/area/arealist";
	}

	@RequestMapping("areaadd")
	public String addarea(Model model){

	return "pages/area/areaadd";
	}
	//添加数据
	@RequestMapping("areainsert")
	public String insertArea(Area area,Model model){
	String forword=request.getParameter("forword");
		areaService.insert(area);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除数据
	@RequestMapping("areadel")
	public String deleteArea(Area area,Model model){
		String forword=request.getParameter("forword");
		areaService.delete(area);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的数据
	@RequestMapping("areaedit")
	public String editArea(Model model,Area area){
		Area c= areaService.get(area.getId());

		model.addAttribute("c", c);
		return "pages/area/areaedit";
	}

	//修改的数据
	@RequestMapping("areaupdate")
	public String updateArea(Area area,Model model){
		String forword=request.getParameter("forword");
		areaService.update(area);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//所有列表页
	@RequestMapping("areaAll")
	public String listAreaAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Area> cs= areaService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Area area=(Area)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Area> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/area/areaAll";
	}
}
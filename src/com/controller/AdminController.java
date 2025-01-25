package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Admin;
import com.service.AdminService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class AdminController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	AdminService adminService;
@Autowired
HttpServletRequest request;
//列表管理页面
	@RequestMapping("adminlist")
	public String listAdmin(Model model){
String w="";

if (!"".equals(request.getParameter("adminname")) && request.getParameter("adminname") !=null)
w=w+ " and adminname like '%"+request.getParameter("adminname")+"%'";

		List<Admin> cs= adminService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Admin admin=(Admin)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Admin> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/admin/adminlist";
	}

	@RequestMapping("adminadd")
	public String addadmin(Model model){

	return "pages/admin/adminadd";
	}
	//添加数据
	@RequestMapping("admininsert")
	public String insertAdmin(Admin admin,Model model){
	String forword=request.getParameter("forword");
		adminService.insert(admin);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除数据
	@RequestMapping("admindel")
	public String deleteAdmin(Admin admin,Model model){
		String forword=request.getParameter("forword");
		adminService.delete(admin);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的数据
	@RequestMapping("adminedit")
	public String editAdmin(Model model,Admin admin){
		Admin c= adminService.get(admin.getId());

		model.addAttribute("c", c);
		return "pages/admin/adminedit";
	}

	//修改的数据
	@RequestMapping("adminupdate")
	public String updateAdmin(Admin admin,Model model){
		String forword=request.getParameter("forword");
		adminService.update(admin);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//所有列表页
	@RequestMapping("adminAll")
	public String listAdminAll(Model model){
String w="";

if (!"".equals(request.getParameter("adminname")) && request.getParameter("adminname") !=null)
w=w+ " and adminname like '%"+request.getParameter("adminname")+"%'";

		List<Admin> cs= adminService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Admin admin=(Admin)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Admin> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/admin/adminAll";
	}
//注册
@RequestMapping("adminreg")
	public String insertreg(Admin admin,Model model){
	String forword=request.getParameter("forword");
	String w=" and username='"+request.getParameter("username")+"'";
	List<Admin> cs= adminService.list(w);
	if (cs.size()>0)
	{
		model.addAttribute("msg","用户名重复!请重试");
		model.addAttribute("path",forword);		
	}
	else{
		adminService.insert(admin);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
	}
		return "success";
	
	}
//修改个人资料
	@RequestMapping("admininfo")
	public String editAdmininfo(Model model,Admin admin){
Admin c= adminService.get(admin.getId());

		model.addAttribute("c", c);
		return "pages/admin/admininfo";
	}

	//保存修改个人资料数据
	@RequestMapping("admininfosave")
	public String Admininfosave(Admin admin,Model model){
		String forword=request.getParameter("forword");
		adminService.update(admin);
model.addAttribute("msg","修改成功");
 model.addAttribute("path",forword);
		return "success";
	}
}
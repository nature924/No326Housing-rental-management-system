package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.entity.Admin;
import com.entity.Huser;
import com.entity.User;
import com.util.Result;

//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class loginController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	com.service.AdminService adminService;
	@Autowired
	com.service.HuserService huserService;
	@Autowired
	com.service.UserService userService;
@Autowired
HttpServletRequest request;

	@RequestMapping("check")
	@ResponseBody
	public Result   login(String username,String pwd,String userType){
		Result rs=null;
	String w="";
	   //System.out.println("userType"+userType);
	Map<String,Object> data=new HashMap<String, Object>();
		if(userType.equals("0"))
		{System.out.println(username);
	        if (!"".equals(username) && username!=null) 
			w=w+ " and adminname ='"+username+"'";
		   if (!"".equals(pwd) && pwd!=null) 
			w=w+ " and pwd ='"+pwd+"'";
			List<Admin> cs= adminService.sealist(w);
			if(cs.size()>0)
			{ 		
			 HttpSession session=request.getSession(); 
				 session.setAttribute("userType", userType);
				Admin s=(Admin)cs.get(0);
	             session.setAttribute("admin", s);
				 session.setAttribute("loginname", username);

						rs=new Result("1", "登陆成功", data);//将json数据返回
				System.out.println(rs.toString());
						}
			else
			{
			rs=new Result("0", "登陆失败", data);
			System.out.println(rs.toString());
			}
		}
		
		 
if(userType.equals("1"))//用户
			{
				 if (!"".equals(username) && username!=null) 
						w=w+ " and username ='"+username+"'";
					   if (!"".equals(pwd) && pwd!=null) 
						w=w+ " and pwd ='"+pwd+"'";
					   
					   List<User> cs= userService.sealist(w);
						if(cs.size()>0)
						{ 		
						 HttpSession session=request.getSession(); 
							 session.setAttribute("userType", userType);
							 User s=(User)cs.get(0);
				             session.setAttribute("user", s);
							 session.setAttribute("loginid", s.getId());

							 session.setAttribute("loginname", username);
							rs=new Result("1", "登陆成功", data);//将信息返回给ajax
							System.out.println(rs.toString());
					
						}
						else
						{
						rs=new Result("0", "登陆失败", data);
						System.out.println(rs.toString());

						}
			}
if(userType.equals("2"))//中介
{
	 if (!"".equals(username) && username!=null) 
			w=w+ " and username ='"+username+"'";
		   if (!"".equals(pwd) && pwd!=null) 
			w=w+ " and pwd ='"+pwd+"'";
		   
		   List<Huser> cs= huserService.sealist(w);
			if(cs.size()>0)
			{ 		
			 HttpSession session=request.getSession(); 
				 session.setAttribute("userType", userType);
				 Huser s=(Huser)cs.get(0);
	             session.setAttribute("huser", s);
				 session.setAttribute("loginid", s.getId());
				 session.setAttribute("loginname", username);
				rs=new Result("1", "登陆成功", data);//将信息返回给ajax
				System.out.println(rs.toString());
		
			}
			else
			{
			rs=new Result("0", "登陆失败", data);
			System.out.println(rs.toString());

			}
}
		
		return rs;

	}
	@RequestMapping("userLogout")
    public String userLogout(Model model)
    {		String forword=request.getParameter("forword");

		 HttpSession session=request.getSession(); 

		session.setAttribute("userType", null);
		session.setAttribute("user", null);
		session.setAttribute("huser", null);

		session.setAttribute("loginid", null);

		session.setAttribute("loginname", null);
		model.addAttribute("msg","退出成功");
		 model.addAttribute("path",forword);
				return "success";
    }
}
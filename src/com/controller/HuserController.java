package com.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.entity.Huser;
import com.service.HuserService;
import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;

//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class HuserController {
    //它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
    @Autowired
    HuserService huserService;
    @Autowired
    HttpServletRequest request;

    //中介列表管理页面
    @RequestMapping("huserlist")
    public String listHuser(Model model) {
        String w = "";
        if (!"".equals(request.getParameter("name")) && request.getParameter("name") != null)
            w = w + " and name like '%" + request.getParameter("name") + "%'";
        if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") != null)
            w = w + " and tel like '%" + request.getParameter("tel") + "%'";
        if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") != null)
            w = w + " and zt like '%" + request.getParameter("zt") + "%'";
        List<Huser> cs = huserService.list(w);
        for (int i = 0; i < cs.size(); i++) {
            Huser huser = (Huser) cs.get(i);
        }
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        } else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        int fromIndex = (index - 1) * Pagesize.size;
        int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
        List<Huser> cs1 = cs.subList(fromIndex, toIndex);
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
        return "pages/huser/huserlist";
    }

    @RequestMapping("huseradd")
    public String addhuser(Model model) {
        return "pages/huser/huseradd";
    }

    //添加中介数据
    @RequestMapping("huserinsert")
    public String insertHuser(Huser huser, Model model) {
        String forword = request.getParameter("forword");
        huserService.insert(huser);
        model.addAttribute("msg", "成功");
        model.addAttribute("path", forword);
        return "success";
    }

    //删除中介数据
    @RequestMapping("huserdel")
    public String deleteHuser(Huser huser, Model model) {
        String forword = request.getParameter("forword");
        huserService.delete(huser);
        model.addAttribute("msg", "删除成功");
        model.addAttribute("path", forword);
        return "success";
    }//提取要修改的中介数据

    @RequestMapping("huseredit")
    public String editHuser(Model model, Huser huser) {
        Huser c = huserService.get(huser.getId());
        model.addAttribute("c", c);
        return "pages/huser/huseredit";
    }

    //修改的中介数据
    @RequestMapping("huserupdate")
    public String updateHuser(Huser huser, Model model) {
        String forword = request.getParameter("forword");
        huserService.update(huser);
        model.addAttribute("msg", "操作成功");
        model.addAttribute("path", forword);
        return "success";
    }

    //中介所有列表页
    @RequestMapping("huserAll")
    public String listHuserAll(Model model) {
        String w = "";
        if (!"".equals(request.getParameter("name")) && request.getParameter("name") != null)
            w = w + " and name like '%" + request.getParameter("name") + "%'";
        if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") != null)
            w = w + " and tel like '%" + request.getParameter("tel") + "%'";
        if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") != null)
            w = w + " and zt like '%" + request.getParameter("zt") + "%'";
        List<Huser> cs = huserService.list(w);
        for (int i = 0; i < cs.size(); i++) {
            Huser huser = (Huser) cs.get(i);
        }
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        } else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        int fromIndex = (index - 1) * Pagesize.size;
        int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
        List<Huser> cs1 = cs.subList(fromIndex, toIndex);
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
        return "pages/huser/huserAll";
    }

    //注册
    @RequestMapping("huserreg")
    public String insertreg(Huser huser, Model model) {
        String forword = request.getParameter("forword");
        String w = " and username='" + request.getParameter("username") + "'";
        List<Huser> cs = huserService.list(w);
        if (cs.size() > 0) {
            model.addAttribute("msg", "用户名重复!请重试");
            model.addAttribute("path", forword);
        } else {
            huserService.insert(huser);
            model.addAttribute("msg", "成功");
            model.addAttribute("path", forword);
        }
        return "success";
    }

    //修改个人资料
    @RequestMapping("huserinfo")
    public String editHuserinfo(Model model, Huser huser) {
        Huser c = huserService.get(huser.getId());
        model.addAttribute("c", c);
        return "pages/huser/huserinfo";
    }

    //保存修改个人资料数据
    @RequestMapping("huserinfosave")
    public String Huserinfosave(Huser huser, Model model) {
        String forword = request.getParameter("forword");
        huserService.update(huser);
        model.addAttribute("msg", "修改成功");
        model.addAttribute("path", forword);
        return "success";
    }
}
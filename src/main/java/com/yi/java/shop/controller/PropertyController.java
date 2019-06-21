/**
* 模仿天猫整站ssm 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.yi.java.shop.controller;

import java.util.List;

import com.yi.java.shop.pojo.Category;
import com.yi.java.shop.pojo.Property;
import com.yi.java.shop.pojo.User;
import com.yi.java.shop.service.CategoryService;
import com.yi.java.shop.service.PropertyService;
import com.yi.java.shop.service.UserService;
import com.yi.java.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyService propertyService;
    @Autowired
    UserService userService;

    @RequestMapping("admin_login_search")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "admin/login";
        }
        session.setAttribute("user", user);
        return "redirect:admin_product_list";
    }
    @RequestMapping("admin_property_add")
    public String add(Model model, Property p) {
        propertyService.add(p);
        return "redirect:admin_property_list?cid="+p.getCid();
    }

    @RequestMapping("admin_property_delete")
    public String delete(int id) {
        Property p = propertyService.get(id);
        propertyService.delete(id);
        return "redirect:admin_property_list?cid="+p.getCid();
    }

    @RequestMapping("admin_property_edit")
    public String edit(Model model, int id) {
        Property p = propertyService.get(id);
        Category c = categoryService.get(p.getCid());
        p.setCategory(c);
        model.addAttribute("p", p);
        return "admin/editProperty";
    }

    @RequestMapping("admin_property_update")
    public String update(Property p) {
        propertyService.update(p);
        return "redirect:admin_property_list?cid="+p.getCid();
    }

    @RequestMapping("admin_property_list")
    public String list(int cid, Model model,  Page page) {
        Category c = categoryService.get(cid);

        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Property> ps = propertyService.list(cid);

        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid="+c.getId());

        model.addAttribute("ps", ps);
        model.addAttribute("c", c);
        model.addAttribute("page", page);

        return "admin/listProperty";
    }
}



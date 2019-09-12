package com.davyd.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlPagesController {
    @RequestMapping("/admin")
    public String adminCategories() {
        return "category.html";
    }
    @RequestMapping("/user")
    public String user() {
        return "user.html";
    }
    @RequestMapping("/product")
    public String product() {
        return "product.html";
    }
    @RequestMapping("/order")
    public String order() {
        return "order.html";
    }
    @RequestMapping("/subcategory")
    public String subcategory() {
        return "subcategory.html";
    }
    @RequestMapping("/adminCategoryZbut")
    public String adminCategoryZbut() {
        return "categoryZbut.html";
    }
    @RequestMapping("/productZbut")
    public String productZbut() {
        return "productZbut.html";
    }
}

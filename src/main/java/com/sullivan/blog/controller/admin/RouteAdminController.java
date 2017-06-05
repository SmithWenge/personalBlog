package com.sullivan.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sullivan
 * @Description 路由到登录页面
 */

@Controller
@RequestMapping("/admin")
public class RouteAdminController {

    @RequestMapping("/routeLogin")
    public String routeLogin() {
        return "admin/login";
    }

    @RequestMapping("/routeMain")
    public String routeMain() {
        return "admin/main";
    }
}

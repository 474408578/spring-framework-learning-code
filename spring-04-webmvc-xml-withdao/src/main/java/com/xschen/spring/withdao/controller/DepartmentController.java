package com.xschen.spring.withdao.controller;

import com.xschen.spring.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xschen
 */

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/department/demo")
    public String demo() {
        System.out.println(departmentService);
        return "demo";
    }
}

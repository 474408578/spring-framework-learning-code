package com.xschen.spring.withdao.controller;

import com.xschen.spring.withdao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xschen
 */

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    @RequestMapping("/demo")
    public String demo() {
        System.out.println(departmentService);
        return "demo";
    }

    @RequestMapping("/deptList")
    public String list(HttpServletRequest request) {
        request.setAttribute("deptList", departmentService.findDepartments(null));
        return "dept/deptList";
    }

    @RequestMapping("deptList2")
    public ModelAndView list2(ModelAndView model) {
        model.addObject("deptList", departmentService.findDepartments(null));
        model.setViewName("dept/deptList");
        return model;
    }

    @RequestMapping("deptList3")
    public String list3(ModelMap modelMap) {
        modelMap.put("deptList", departmentService.findDepartments(null));
        return "dept/deptList";

    }

    @RequestMapping("/deptList4")
    public String list4(HttpServletRequest request, String name) {
        request.setAttribute("deptList", departmentService.findDepartmentsByName(name));
        return "dept/deptList";
    }
}

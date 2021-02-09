package com.xschen.spring.b_annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xschen
 */

@Controller
public class DemoController {

    @RequestMapping("demo1")
    public String demo() {
        return "demo";
    }
}

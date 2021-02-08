package com.xschen.spring.a_quickstart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xschen
 */

@Controller
public class DemoController {

    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }
}

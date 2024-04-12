package com.example.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/test-controler")
    public ModelAndView testMethod(){
        ModelAndView result = new ModelAndView("test-page");
        return result;
    }
}

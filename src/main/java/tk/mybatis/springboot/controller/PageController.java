package tk.mybatis.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 10:46 AM 7/24/2018
 */
@Controller
public class PageController {

    @RequestMapping("/demo")
    public ModelAndView demo() {
        ModelAndView result = new ModelAndView("demo");
        return result;
    }

    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView result = new ModelAndView("hello");
        return result;
    }

    @RequestMapping("/step1")
    public ModelAndView step1() {
        ModelAndView result = new ModelAndView("step1");
        return result;
    }
}

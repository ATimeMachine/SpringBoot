package com.example.security.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 知识点：@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 * 1) 如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，或者html，
 * 配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 *
 * 2) 如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 *     如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 *
 * 例如：
 * 1.使用@Controller 注解，在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面
 * 若返回json等内容到页面，则需要加@ResponseBody注解
 *
 */

@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(@RequestParam("i") Integer i,HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (i == 1) {
            //这个重定向没用，因为用的是RestController
            return "redirect:result";
        } else {
            //使用RedirectAttributes暂时不成功
            HttpSession session = request.getSession();
            session.setAttribute("session", i);
            response.sendRedirect("result");
            return null;
        }
    }

    @RequestMapping("result")
    @ResponseBody
    public String result(HttpServletRequest request) {
        Object session = request.getSession().getAttribute("session");
        System.out.println(session);
        return "hello spring security:" + session;
    }
}
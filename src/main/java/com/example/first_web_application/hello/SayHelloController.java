package com.example.first_web_application.hello ;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }


    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>Hello World</h1>");
        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJSP(@RequestParam String name, ModelMap model) {
        model.put("name", name);

        return "sayHello";
    }

}

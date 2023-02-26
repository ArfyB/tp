package com.tp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menur")
public class MenuRecController
{
    @RequestMapping("/main")
    public String Main()
    {
    	return "thyleaf/main/MenuRecSerive";
    }
}
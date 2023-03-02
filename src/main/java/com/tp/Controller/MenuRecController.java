package com.tp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp.Service.rdmenu;
import com.tp.Vo.RdMenu;

@Controller
@RequestMapping("/msel")
public class MenuRecController
{
	@Autowired
	public rdmenu rm;
	
    @RequestMapping("/msel")
    public String msel(Model m)
    {
    	return "thymeleaf/menu_rec/msel";
    }
    
    @RequestMapping("/mseladd")
    public String mseladd()
    {
    	return "thymeleaf/menu_rec/mseladd";
    }
    
    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Boolean> upload(RdMenu rd)
    {
    	Map<String, Boolean> map = new HashMap<>();
    	map.put("added", rm.added(rd));
    	
    	return map;
    }
    
    @PostMapping("/getrdwithmg")
    @ResponseBody
    public Map<String, Object> getrdwithmg(RdMenu rd)
    {
    	String rs = rm.getrdwithmg(rd).getMname();
    	Map<String, Object> map = new HashMap<>();
    	map.put("rd", rs);
    	
    	return map;
    }
}
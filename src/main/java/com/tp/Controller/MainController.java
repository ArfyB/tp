package com.tp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menurec")
public class  MainController
{
	@RequestMapping("/main")
	public String main()
	{
		return "thymeleaf/menurec/main";
	}
	
	@RequestMapping("/guide")
	public String guide()
	{
		return "thymeleaf/menurec/guide";
	}

	@RequestMapping("/board")
	public String board()
	{
		return "thymeleaf/board/BoardList";
	}
}
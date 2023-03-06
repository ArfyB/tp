package com.tp.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tp.Vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tp.Mapper.BoardMapper;
import com.tp.Service.BoardService;
import com.tp.Vo.Board;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("board")
@Controller
public class BoardController 
{
	@Autowired
	public BoardService bs; 
	
	@Autowired
	public BoardMapper bm;
	
	@RequestMapping("/main")
	public String main(Model m)
	{
		Map<String,Object> a = new HashMap<>();
		m.addAttribute("boardh", bs.GetBoardHit());
		m.addAttribute("boardb", bs.GetBoardBnum());
		return "thymeleaf/board/boardmain";
	}
	
	@GetMapping("/add")
	public String add()
	{
		return "thymeleaf/board/BoardAdd";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String,Boolean> add(Board brd, HttpServletRequest request)
	{
		Map<String,Boolean> map = new HashMap<>();
		String uid = (String)request.getSession().getAttribute("uid");
		brd.setAuthor(uid);
		map.put("added", bs.BoardAdd(brd));
		return map;
	}
	
	@RequestMapping("/list/{page}/{row}")
	public String list(@PathVariable("page")int page, @PathVariable("row")int row, Model m)
	{
		PageHelper.startPage(page,row);
		PageInfo <Map<String,Object>> pageinfo = new PageInfo<>(bm.AllBoard());
		
		m.addAttribute("pageinfo", pageinfo);
		m.addAttribute("pages", bs.pages(pageinfo));  // 페이지이동
		
		return "thymeleaf/recipe/RecipeList";


	}
	
	@RequestMapping("/detail/{rnum}")
	public String detail(@PathVariable("bnum") int bnum, Model m)
	{
		
		m.addAttribute("r",bs.GetUphitBoard(bnum));
		return "thymeleaf/recipe/RecipeDetail";
	}
	
	@PostMapping("/upload")
    @ResponseBody
      public Map<String, Object> upload(@RequestParam("files")MultipartFile[] mfiles,
                        HttpServletRequest request,				
                        Board brd) 
      {
       Map<String, Object> map = new HashMap<>();
       
       map.put("mfiles", mfiles);
       map.put("request", request);
       map.put("board", brd);
       
       Map<String, Object> added = new HashMap<>();
       added.put("added", bs.AddBrd(map));
       
       return added;
	  }

	@RequestMapping("/comment")
	public String comment() {
		return "thymeleaf/board/AddComment";
	}

}

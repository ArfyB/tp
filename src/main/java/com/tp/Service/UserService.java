package com.tp.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.tp.Mapper.BoardMapper;
import com.tp.Vo.Board;
import com.tp.Vo.BoardPic;
import com.tp.Vo.RecipePic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService 
{
	@Autowired
	ResourceLoader resourceLoader;
	
	@Autowired
	public BoardMapper bm;
	
	public List<Map<String, Object>> AllRecipe() 
	{
		//List<Recipe>
		return bm.AllBoard();
	}
	
	public Board GetUphitBoard(int bnum)
	{
		int a = bm.uphit(bnum);
		Board b = bm.GetBoard(bnum);
		return b;
	}
	
	public Board GetBoard(int bnum)
	{
		Board b = bm.GetBoard(bnum);
		return b;
	}
	
	public List<Board> GetBoardHit()
	{
		List<Board> b = bm.GetBoardHit();
		return b;
	}
	
	public List<Board> GetBoardBnum()
	{
		List<Board> b = bm.GetBoardBnum();
		return b;
	}
	
	public boolean BoardAdd(Board brd)
	{
		int add = bm.BoardAdd(brd);
		return add>=1;
	}
	
	public Map<String,Object> pages(PageInfo pageinfo)
	{
		Map<String,Object> map = new HashMap<>();
		
		 System.out.println();
		
		int begin = pageinfo.getPageNum()-2;
		
		if(begin<=0)
		{
			begin = 1;
		}
		
		int end = pageinfo.getPageNum()+2;
		if(end>=pageinfo.getNavigateLastPage())
		{
			end = pageinfo.getNavigateLastPage();
		}
		
		
		map.put("begin", begin);
		map.put("end", end);
		return map;
	}
	
	public boolean AddBrd(Map map)
	   {
		  MultipartFile[] mfiles = (MultipartFile[]) map.get("mfiles");
	      HttpServletRequest request = (HttpServletRequest) map.get("request");
	      Board brd = (Board) map.get("board");
	      
	      ServletContext context = request.getServletContext();

	      List<BoardPic> list = new ArrayList<>();
	      String absolutePath="";
	         
	      Resource resource = resourceLoader.getResource("classpath:/static");
	         
	      try 
	      {
	    	  absolutePath = resource.getFile().getAbsolutePath();
	    	  System.out.println(absolutePath);
	    	  if(mfiles.length != 0)
	    	  {
	    		  for(int i=0;i<mfiles.length;i++) 
	    		  {
	    			  mfiles[i].transferTo(
	    					  new File(absolutePath+"/pics/"+mfiles[i].getOriginalFilename()));
	               
	    			  BoardPic bp = new BoardPic();
	    			  bp.setFname(mfiles[i].getOriginalFilename());
	    			  brd.setBpic(mfiles[i].getOriginalFilename());
	    			  
	               
	    			  list.add(bp);
	    		  }
	    		  
	    		int add = bm.BoardAdd(brd);
	            int b = bm.BrdPicAdd(list);
	            
	         }
	            
	            return true;
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	         }

	      /*
	      여러개 업로드
	      MultipartFile[] mfiles = (MultipartFile[]) map.get("mfiles");
	      HttpServletRequest request = (HttpServletRequest) map.get("request");
	      Recipe rec = (Recipe) map.get("recipe");
	      
	      ServletContext context = request.getServletContext();

	      List<RecipePic> list = new ArrayList<>();
	      String absolutePath="";
	         
	      Resource resource = resourceLoader.getResource("classpath:/static");
	         
	      try 
	      {
	    	  absolutePath = resource.getFile().getAbsolutePath();
	    	  if(mfiles.length != 0)
	    	  {
	               
	    		  for(int i=0;i<mfiles.length;i++) 
	    		  {
	    			  System.out.println("스태틱  " + absolutePath + "/pics/" + mfiles[i].getOriginalFilename());
	    			  mfiles[i].transferTo(
	    					  new File(absolutePath+"/pics/"+mfiles[i].getOriginalFilename()));
	               
	    			  RecipePic rp = new RecipePic();
	    			  rp.setFname(mfiles[i].getOriginalFilename());
	    			  rec.setRpic(mfiles[i].getOriginalFilename());
	               
	               
	    			  list.add(rp);
	    		  }
	            
	            int a = rm.RecipeAdd(rec);
	            System.out.println(list.get(0));
	            int b = rm.RecPicAdd(list);
	            
	            }
	            
	            return true;
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	         }
	         */
	  }
}

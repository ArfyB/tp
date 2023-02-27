package com.tp.Service;

import java.io.File;
import java.sql.Date;
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
import com.tp.Mapper.RecipeMapper;
import com.tp.Vo.Recipe;
import com.tp.Vo.RecipePic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class RecipeService 
{
	@Autowired
	ResourceLoader resourceLoader;
	
	@Autowired
	public RecipeMapper rm;
	
	public List<Map<String, Object>> AllRecipe() 
	{
		//List<Recipe>
		return rm.AllRecipe();
	}
	
	public Recipe GetUphitRecipe(int rnum)
	{
		int a = rm.uphit(rnum);
		Recipe r = rm.GetRecipe(rnum);
		return r;
	}
	
	public Recipe GetRecipe(int rnum)
	{
		Recipe r = rm.GetRecipe(rnum);
		return r;
	}
	
	public List<Recipe> GetRecipeHit()
	{
		List<Recipe> r = rm.GetRecipeHit();
		return r;
	}
	
	public List<Recipe> GetRecipeRnum()
	{
		List<Recipe> r = rm.GetRecipeRnum();
		return r;
	}
	
	public boolean RecipeAdd(Recipe rec)
	{
		int add = rm.RecipeAdd(rec);
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
	
	public boolean AddRec(Map map)
	   {
		  MultipartFile[] mfiles = (MultipartFile[]) map.get("mfiles");
	      HttpServletRequest request = (HttpServletRequest) map.get("request");
	      Recipe rec = (Recipe) map.get("recipe");
	      
	      java.util.Date utilDate = new java.util.Date(); // 현재시간을 java.util.Date 객체로 가져옴
	      rec.setRecdate(new java.sql.Date(utilDate.getTime())); 
	      
	      /*
	      System.out.println(rec.getAuthor());
	      System.out.println(rec.getCategory());
	      System.out.println(rec.getCatemat());
	      System.out.println(rec.getDifficult());
	      System.out.println(rec.getHits());
	      System.out.println(rec.getHow());
	      System.out.println(rec.getHuman());
	      System.out.println(rec.getInfo());
	      System.out.println(rec.getRacc());
	      System.out.println(rec.getRnum());
	      System.out.println(rec.getRpic());
	      System.out.println(rec.getTime());
	      System.out.println(rec.getTitle());
	      System.out.println(rec.getRecdate());
	      */
	      
	      
	      ServletContext context = request.getServletContext();

	      List<RecipePic> list = new ArrayList<>();
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
	               
	    			  RecipePic rp = new RecipePic();
	    			  rp.setFname(mfiles[i].getOriginalFilename());
	    			  rec.setRpic(mfiles[i].getOriginalFilename());
	    			  
	               
	    			  list.add(rp);
	    		  }
	    		rec.setRpic(mfiles[0].getOriginalFilename());
	    		int add = rm.RecipeAdd(rec);
	            //int b = rm.RecPicAdd(list);
	            
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

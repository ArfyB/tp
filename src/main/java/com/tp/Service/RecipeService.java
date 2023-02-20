package com.tp.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.Mapper.RecipeMapper;
import com.tp.Vo.Recipe;

@Service
public class RecipeService 
{
	@Autowired
	public RecipeMapper rm;
	
	public List<Map<String, Object>> AllRecipe() 
	{
		//List<Recipe>
		return rm.AllRecipe();
	}
	
	
	public boolean RecipeAdd(Recipe rec)
	{
		System.out.println("레시피넘버 int : " + rec.getRnum());
		System.out.println("레시피이름 : " + rec.getTitle());
		System.out.println("요리소개 : " + rec.getInfo());
		System.out.println("작성자 : " + rec.getAuthor());
		System.out.println("조회수 int : " + rec.getHits());
		System.out.println("작성일 Date : " + rec.getRecdate());
		System.out.println("카테고리 : " + rec.getCategory());
		System.out.println("방법 : " + rec.getHow());
		System.out.println("주재료 : " + rec.getCatemat());
		System.out.println("인원수 : " + rec.getHuman());
		System.out.println("조리시간 int : " + rec.getTime());
		System.out.println("난이도 : " + rec.getDifficult());
		
		int add = rm.RecipeAdd(rec);
		return add>=1;
	}
}

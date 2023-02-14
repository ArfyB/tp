package com.tp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.Mapper.RecipeMapper;
import com.tp.Vo.Recipe;

@Service
public class RecipeService 
{
	@Autowired
	public RecipeMapper rm;
	
	public List<Recipe> AllRecipe() 
	{
		List<Recipe> AllRec = rm.AllRecipe();
		return AllRec;
	}
	
	public boolean RecipeAdd(Recipe rec)
	{
		
		int add = rm.RecipeAdd(rec);
		return add>=1;
	}
}

package com.tp.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tp.Vo.Recipe;

@Mapper
public interface RecipeMapper 
{
	public List<Recipe> AllRecipe();
	public int RecipeAdd(Recipe rec);
}

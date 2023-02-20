package com.tp.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tp.Vo.Recipe;

@Mapper
public interface RecipeMapper
{
	public List<Map<String, Object>> AllRecipe();
	public int RecipeAdd(Recipe rec);
}

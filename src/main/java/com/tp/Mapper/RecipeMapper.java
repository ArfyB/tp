package com.tp.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tp.Vo.Recipe;
import com.tp.Vo.RecipePic;

@Mapper
public interface RecipeMapper
{
	public List<Map<String, Object>> AllRecipe();
	public int RecipeAdd(Recipe rec);
	public int RecPicAdd(List<RecipePic> list);
	public Recipe GetRecipe(int rnum);
	public int uphit(int rnum);
}

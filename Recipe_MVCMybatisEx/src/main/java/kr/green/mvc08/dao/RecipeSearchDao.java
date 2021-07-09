package kr.green.mvc08.dao;

import java.util.HashMap;
import java.util.List;

import kr.green.mvc08.vo.RecipeVO;



public interface RecipeSearchDao {
	
	List<RecipeVO> selectRecipeByParts(HashMap<String, List<String>> map);
	List<RecipeVO> recipeSearchByName(String forSearchString);

}

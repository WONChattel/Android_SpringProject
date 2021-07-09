package kr.green.mvc08.service;

import java.util.List;

import kr.green.mvc08.vo.RecipeVO;

public interface RecipeSearchService {

	List<RecipeVO> selectRecipeByParts(List<String> forSearchList);
	List<RecipeVO> recipeSearchByName(String forSearchString);

}

package kr.green.mvc08.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.green.mvc08.dao.RecipeSearchDao;
import kr.green.mvc08.vo.RecipeVO;


@Service("recipeSearchService")
@Transactional
public class RecipeSearchServiceImpl implements RecipeSearchService {

	@Autowired
	RecipeSearchDao recipeSearchDao;

	@Override
	public List<RecipeVO> selectRecipeByParts(List<String> forSearchList) {
	    HashMap<String, List<String>> map = new HashMap<>();
	    map.put("forSearchList", forSearchList);
		return recipeSearchDao.selectRecipeByParts(map);
	}

	@Override
	public List<RecipeVO> recipeSearchByName(String forSearchString) {
		return recipeSearchDao.recipeSearchByName(forSearchString);
	}
	

}

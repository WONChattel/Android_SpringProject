package kr.green.mvc08;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.green.mvc08.service.RecipeSearchService;
import kr.green.mvc08.vo.RecipeVO;

@Controller
public class RecipeSearchController {
	
		
	private static final Logger logger = LoggerFactory.getLogger(RecipeSearchController.class);

	@Autowired
	RecipeSearchService recipeSearchService;
	
	
	
	@RequestMapping(value = "/recipesearch1",  method = RequestMethod.POST )
	@ResponseBody
	public List<RecipeVO> androidTestWithRequestAndResponse1(HttpServletRequest request) {
		logger.info("search1 connection from Android");
		List<String> forSearchList = new ArrayList<>();
		Gson gson =new Gson();
		String json =  readJSONStringFromRequestBody(request);
		
		System.out.println(json);
		forSearchList= gson.fromJson(json, new TypeToken<List<String>>(){}.getType());
		System.out.print(forSearchList);
		List<RecipeVO>list1= recipeSearchService.selectRecipeByParts(forSearchList);
		return list1;
	}
	
	
	@RequestMapping(value = "/recipesearch2",  method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody //나중에HttpServletRequest 안드로이드 request로 인수로 하여 수정할것
	public List<RecipeVO> androidTestWithRequestAndResponse2(@RequestParam String word, HttpServletRequest request) {
		logger.info("search2 connection from Android");
		
		//String word = (String) request.getAttribute("word");
		List<RecipeVO> list= recipeSearchService.recipeSearchByName(word);
		return list;
	}
	
	private String readJSONStringFromRequestBody(HttpServletRequest request){
	    StringBuffer json = new StringBuffer();
	    String line = null;
	 
	    try {
	        BufferedReader reader = request.getReader();
	        while((line = reader.readLine()) != null) {
	            json.append(line);
	        }
	 
	    }catch(Exception e) {
	        System.out.println("Error reading JSON string: " + e.toString());
	    }
	    return json.toString();
	}
	


	
}

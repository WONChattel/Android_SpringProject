package kr.green.mvc08;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.mvc08.service.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	TestService testService;
	
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		String today= testService.selectToday();
		int sum = testService.selectSum(11, 12412);
		int mul = testService.selectMul(1, 2, 4);
		
		
		model.addAttribute("today", today );
		model.addAttribute("sum", sum );
		model.addAttribute("mul", mul );
		
		return "home";
	}
	
	

	
}

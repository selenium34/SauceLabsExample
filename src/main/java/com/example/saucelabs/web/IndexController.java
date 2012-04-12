package com.example.saucelabs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	private static int i;
	
	@RequestMapping(value = "/landing.html", method=RequestMethod.GET) 
	public ModelAndView displayPage() {
		ModelAndView mav = new ModelAndView("landing");
		mav.addObject("title", "Try " + ++i);
		return mav;
	}
	
	@RequestMapping(value = "/index.html", method=RequestMethod.GET)
	public String redirectToLandingPage() {
		return "redirect:/landing.html";
	}
	
}

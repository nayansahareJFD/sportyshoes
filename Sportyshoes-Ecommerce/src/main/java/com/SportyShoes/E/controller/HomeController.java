package com.SportyShoes.E.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	
	 @RequestMapping("/Home")
	    public String Home(){
	    	System.out.println("this is home calling");
	        return "HomeIndex";
	    }

}

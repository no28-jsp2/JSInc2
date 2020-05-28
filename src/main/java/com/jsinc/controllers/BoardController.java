package com.jsinc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	
	
	
	
	@RequestMapping("allCompany")
	public String allCompony() {
		return "board/allCompany";
	}
	
	@RequestMapping("departmentBoard")
	public String department() {
		return "board/departmentBoard";
	}
	
	@RequestMapping("reference")
	public String reference() {
		return "board/reference";
	}
	
}

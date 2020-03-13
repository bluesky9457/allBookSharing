package com.allBookSharing.xxx;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.constraints.ISBN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.allBookSharing.xxx.dto.Books;
import com.allBookSharing.xxx.dto.Reservation;
import com.allBookSharing.xxx.service.BookManagement;
import com.allBookSharing.xxx.service.LibrarianManagement;

@RestController

public class AdminRestController {
	@Autowired
	private LibrarianManagement la;
	ModelAndView mav;
	
	
	@GetMapping(value="/sub1",produces="application/json;charset=UTF-8")
	public String sub1() {
		System.out.println("검색1");
		
		
		
		return null;
	} 

}

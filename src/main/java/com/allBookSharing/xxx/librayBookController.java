package com.allBookSharing.xxx;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class librayBookController {
	private ModelAndView mav;
	
	//@PreAuthorize("isAnonymous()")
	@RequestMapping(value = "/lrest/libray/book/insertmove")
	public String bookInsertMove() {
		
		return "librarian/bookinsert";
	}
	
}

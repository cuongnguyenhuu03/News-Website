package com.huucuong.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huucuong.dto.NewsDTO;
import com.huucuong.service.INewService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@Autowired
	private INewService newService;

   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage(@RequestParam("page") int page, @RequestParam("limit") int limit) {
	  NewsDTO model = new NewsDTO();
	  model.setPage(page);
	  model.setLimit(limit);

      ModelAndView mav = new ModelAndView("web/home");
      
      Pageable pageable = new PageRequest(page-1, limit);
      model.setTotalItem(newService.getTotaltem());
      model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
      
      model.setListResult(newService.findAll(pageable));
      mav.addObject("model",model);
      return mav;
   }
   
   @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
   public ModelAndView loginPage() {
      ModelAndView mav = new ModelAndView("login");
      return mav;
   }
   
   @RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
   public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
	   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			// remove secsion 
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
      return new ModelAndView("redirect:/trang-chu");
   }
   
   @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
   public ModelAndView acccessDenied() {
	   return new ModelAndView("redirect:/dang-nhap?acccessDenied");
   }
}   
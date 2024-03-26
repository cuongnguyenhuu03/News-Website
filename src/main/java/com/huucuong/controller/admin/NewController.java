package com.huucuong.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huucuong.Util.MessageUtil;
import com.huucuong.dto.NewsDTO;
import com.huucuong.service.ICategoryService;
import com.huucuong.service.INewService;

@Controller(value = "newControllerOfAdmin")
public class NewController {

	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	
   @RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
   public ModelAndView showList(@RequestParam("page") int page,
		   						@RequestParam("limit") int limit,
		   						HttpServletRequest request) {
	  NewsDTO model = new NewsDTO();
	  model.setPage(page);
	  model.setLimit(limit);
      ModelAndView mav = new ModelAndView("admin/new/list");
      
      //paging 
      Pageable pageable = new PageRequest(page-1, limit);
      model.setTotalItem(newService.getTotaltem());
	  model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
      
	  if(request.getParameter("message") != null) {
    	  Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
    	  mav.addObject("message", message.get("message"));
    	  mav.addObject("alert", message.get("alert"));
      }
	  
      model.setListResult(newService.findAll(pageable));
      mav.addObject("model", model );
      return mav;
   }
   
   @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
   public ModelAndView editNews(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request ) {
      ModelAndView mav = new ModelAndView("admin/new/edit");
      NewsDTO model  = new NewsDTO();
      if(id != null) {
    	  model = newService.findById(id);
      }
      
      if(request.getParameter("message") != null) {
    	  Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
    	  mav.addObject("message", message.get("message"));
    	  mav.addObject("alert", message.get("alert"));
      }
      mav.addObject("categories", categoryService.findAll());
      mav.addObject("model", model);
      return mav;
   }
}   
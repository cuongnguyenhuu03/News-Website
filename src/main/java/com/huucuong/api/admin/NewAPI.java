package com.huucuong.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huucuong.dto.NewsDTO;
import com.huucuong.service.INewService;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService newsService;
	
	@PostMapping("/api/new")
	public NewsDTO createNew(@RequestBody NewsDTO newDTO) {
		return newsService.save(newDTO);	
	}
	
	@PutMapping("/api/new")
	public NewsDTO updateNew(@RequestBody NewsDTO updateNews) {
		return newsService.save(updateNews);	
	}
	
	@DeleteMapping("/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		newsService.delete(ids);
	}
	
}

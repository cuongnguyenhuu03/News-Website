package com.huucuong.converter;

import org.springframework.stereotype.Component;

import com.huucuong.dto.CategoryDTO;
import com.huucuong.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO result  = new CategoryDTO();
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		result.setCode(entity.getCode());
		return result;
	}
	
	public CategoryEntity toEntity (CategoryDTO dto) {
		CategoryEntity result  = new CategoryEntity();
		result.setName(dto.getName());
		result.setCode(dto.getCode());		
		return result; 
	}
}

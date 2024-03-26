package com.huucuong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huucuong.converter.NewsConverter;
import com.huucuong.dto.NewsDTO;
import com.huucuong.entity.CategoryEntity;
import com.huucuong.entity.NewsEntity;
import com.huucuong.repository.CategoryRepository;
import com.huucuong.repository.NewsRepository;
import com.huucuong.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Autowired
	private NewsConverter newsConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		
		List<NewsDTO> models = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		
		for (NewsEntity item: entities) {
			NewsDTO newsDTO = newsConverter.toDTO(item);
			models.add(newsDTO);
		}
		return models;
	}

	@Override
	public int getTotaltem() {
		return (int) newsRepository.count();
	}

	@Override
	public NewsDTO findById(long id) {
		NewsEntity newsEntity = newsRepository.findOne(id);
		return newsConverter.toDTO(newsEntity);
	}

	@Override
	@Transactional
	public NewsDTO save(NewsDTO dto) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewsEntity newsEntity = new NewsEntity();
		if(dto.getId() != null) {
			NewsEntity oldNews = newsRepository.findOne(dto.getId());
			oldNews.setCategory(categoryEntity);
			newsEntity = newsConverter.toEntity(oldNews, dto);
		}else {
			newsEntity = newsConverter.toEntity(dto);
			newsEntity.setCategory(categoryEntity);
		}
		return newsConverter.toDTO(newsRepository.save(newsEntity));
	}
	
	

}

package com.huucuong.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.huucuong.dto.NewsDTO;

public interface INewService {
	List<NewsDTO> findAll(Pageable pageable);
	int getTotaltem();
	NewsDTO findById(long id);
	NewsDTO save(NewsDTO dto);
	void delete(long[] id);
}

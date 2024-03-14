package com.huucuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huucuong.entity.NewsEntity;


public interface NewsRepository extends JpaRepository<NewsEntity, Long > {
	
}

package com.huucuong.dao;

import java.util.List;

import com.huucuong.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findAll();
}

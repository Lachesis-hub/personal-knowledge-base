package com.personalkb.service;

import com.personalkb.dto.CategoryAddDTO;
import com.personalkb.entity.Category;

import java.util.List;

public interface CategoryService {

    void add(CategoryAddDTO dto);

    List<Category> list();
}
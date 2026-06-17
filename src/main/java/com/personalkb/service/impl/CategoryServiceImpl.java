package com.personalkb.service.impl;

import com.personalkb.dto.CategoryAddDTO;
import com.personalkb.entity.Category;
import com.personalkb.mapper.CategoryMapper;
import com.personalkb.service.CategoryService;
import com.personalkb.utils.UserContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void add(CategoryAddDTO dto) {

        Category category = new Category();

        category.setName(dto.getName());

        category.setUserId(
                UserContext.get()
        );

        categoryMapper.insert(category);
    }

    @Override
    public List<Category> list() {

        return categoryMapper.selectByUserId(
                UserContext.get()
        );
    }
}
package com.personalkb.mapper;

import com.personalkb.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int insert(Category category);

    List<Category> selectByUserId(Long userId);

}
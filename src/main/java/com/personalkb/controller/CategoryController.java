package com.personalkb.controller;

import com.personalkb.common.Result;
import com.personalkb.dto.CategoryAddDTO;
import com.personalkb.entity.Category;
import com.personalkb.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(
            CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public Result<Void> add(
            @RequestBody CategoryAddDTO dto) {

        categoryService.add(dto);

        return Result.success(null);
    }

    @GetMapping("/list")
    public Result<List<Category>> list() {

        return Result.success(
                categoryService.list()
        );
    }
}
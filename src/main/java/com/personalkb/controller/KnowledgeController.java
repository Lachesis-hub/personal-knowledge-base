package com.personalkb.controller;

import com.personalkb.common.Result;
import com.personalkb.dto.KnowledgeAddDTO;
import com.personalkb.entity.Knowledge;
import com.personalkb.service.KnowledgeService;
import com.personalkb.vo.KnowledgeListVO;
import com.personalkb.vo.PageResult;
import org.springframework.web.bind.annotation.*;
import com.personalkb.dto.KnowledgeUpdateDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    public KnowledgeController(
            KnowledgeService knowledgeService) {

        this.knowledgeService = knowledgeService;
    }

    @PostMapping("/add")
    public Result<Void> add(
            @RequestBody KnowledgeAddDTO dto) {

        knowledgeService.add(dto);

        return Result.success(null);
    }

    @GetMapping("/list")
    public Result<List<KnowledgeListVO>> list() {

        return Result.success(
                knowledgeService.list()
        );
    }

    @GetMapping("/category/{categoryId}")
    public Result<List<KnowledgeListVO>>
    categoryList(
            @PathVariable Long categoryId) {

        return Result.success(
                knowledgeService
                        .listByCategory(categoryId)
        );
    }

    @GetMapping("/detail/{id}")
    public Result<Knowledge> detail(
            @PathVariable Long id) {

        return Result.success(
                knowledgeService.detail(id)
        );
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(
            @PathVariable Long id) {

        knowledgeService.delete(id);

        return Result.success(null);
    }

    @PutMapping("/update")
    public Result<Void> update(
            @RequestBody KnowledgeUpdateDTO dto) {

        knowledgeService.update(dto);

        return Result.success(null);
    }


    @GetMapping("/page")
    public Result<PageResult<KnowledgeListVO>> page(

            @RequestParam Integer page,

            @RequestParam Integer pageSize) {

        return Result.success(
                knowledgeService.page(
                        page,
                        pageSize
                )
        );
    }

    @GetMapping("/search")
    public Result<List<KnowledgeListVO>> search(
            @RequestParam String keyword
    ){

        return Result.success(
                knowledgeService.search(keyword)
        );
    }
}
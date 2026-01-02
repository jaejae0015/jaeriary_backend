package com.jaeriary.backend.diary.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaeriary.backend.diary.dto.DiaryCreateRequest;
import com.jaeriary.backend.diary.dto.DiaryUpdateRequest;
import com.jaeriary.backend.diary.entity.Diary;
import com.jaeriary.backend.diary.service.DiaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/diaries")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @GetMapping
    public List<Diary> list() {
        return diaryService.findAll();
    }

    @PostMapping
    public Diary create(@RequestBody DiaryCreateRequest request) {
        return diaryService.create(request);
    }

    @PutMapping("/{id}")
    public Diary update(
            @PathVariable("id") Long id,
            @RequestBody DiaryUpdateRequest request
    ) {
        return diaryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        diaryService.delete(id);
    }
    @GetMapping("/{id}")
    public Diary getOne(@PathVariable("id") Long id) {
        return diaryService.findById(id);
    }
}
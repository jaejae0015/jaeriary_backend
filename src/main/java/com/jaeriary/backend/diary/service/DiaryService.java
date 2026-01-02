package com.jaeriary.backend.diary.service;

import com.jaeriary.backend.diary.dto.*;
import com.jaeriary.backend.diary.entity.Diary;

import java.util.List;

public interface DiaryService {

    List<Diary> findAll();

    Diary create(DiaryCreateRequest request);

    Diary update(Long id, DiaryUpdateRequest request);

    void delete(Long id);
    
    Diary findById(Long id);
}
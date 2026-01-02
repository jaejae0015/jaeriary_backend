package com.jaeriary.backend.diary.serviceImpl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaeriary.backend.diary.dto.DiaryCreateRequest;
import com.jaeriary.backend.diary.dto.DiaryUpdateRequest;
import com.jaeriary.backend.diary.entity.Diary;
import com.jaeriary.backend.diary.repository.DiaryRepository;
import com.jaeriary.backend.diary.service.DiaryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // ⭐ NullPointerException 방지
@Transactional
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    @Override
    public List<Diary> findAll() {
        return diaryRepository.findAll();
    }

    @Override
    public Diary create(DiaryCreateRequest request) {
        Diary diary = Diary.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        return diaryRepository.save(diary);
    }

    @Override
    public Diary update(Long id, DiaryUpdateRequest request) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Diary not found"));

        diary.setTitle(request.getTitle());
        diary.setContent(request.getContent());

        return diary;
    }

    @Override
    public void delete(Long id) {
        diaryRepository.deleteById(id);
    }
    @Override
    public Diary findById(Long id) {
        return diaryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Diary not found"));
    }
    
}
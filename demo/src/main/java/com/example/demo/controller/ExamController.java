package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.demo.services.ExamService;
import com.example.demo.model.User;



@RestController
@RequestMapping("/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/{examId}/students")
    public List<User> getStudents(@PathVariable Long examId) {
        return examService.getStudentsForExam(examId);
    }
}
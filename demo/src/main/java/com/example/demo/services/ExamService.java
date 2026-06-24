package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.model.Enrollment;
import com.example.demo.repository.EnrollmentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final EnrollmentRepository enrollmentRepository;

    public ExamService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<User> getStudentsForExam(Long examId) {
        return enrollmentRepository.findByExamId(examId)
                .stream()
                .map(Enrollment::getStudent)
                .toList();
    }
}
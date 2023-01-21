package com.tikal.workshop.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tikal.workshop.entity.Student;
import com.tikal.workshop.json.StudentJson;
import com.tikal.workshop.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StudentListener {

    final private StudentRepository studentRepository;
    final private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public StudentListener(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @KafkaListener(topics="students", groupId = "students", concurrency = "3")
    public void handle(String payload) {
        try {
            StudentJson studentJson = objectMapper.readValue(payload, StudentJson.class);

            Student student = studentJson.toEntity();
            studentRepository.save(student);
        } catch (JsonProcessingException ignored) {
        }
    }
}

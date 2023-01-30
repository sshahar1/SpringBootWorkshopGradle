package com.tikal.workshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tikal.workshop.entity.Student;
import com.tikal.workshop.exception.StudentNotFoundException;
import com.tikal.workshop.json.StudentJson;
import com.tikal.workshop.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    final private KafkaTemplate<String, String> kafkaTemplate;
    final private ObjectMapper objectMapper = new ObjectMapper();
    final private StudentRepository studentRepository;

    @Autowired
    public StudentService(KafkaTemplate<String, String> kafkaTemplate, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") StudentRepository studentRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.studentRepository = studentRepository;
    }

    public void save(StudentJson student) throws JsonProcessingException {
        this.kafkaTemplate.send("students", objectMapper.writeValueAsString(student));
    }

    public StudentJson getByName(String name) throws StudentNotFoundException {
        Student student = this.studentRepository.getStudentByName(name);
        if ( student == null ) {
            throw new StudentNotFoundException();
        }
        return new StudentJson(student);
    }
}

package com.tikal.workshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tikal.workshop.json.StudentJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    final private KafkaTemplate<String, String> kafkaTemplate;
    final private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public StudentService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void save(StudentJson student) throws JsonProcessingException {
        this.kafkaTemplate.send("students", objectMapper.writeValueAsString(student));
    }
}

package com.tikal.workshop.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tikal.workshop.entity.Student;
import com.tikal.workshop.json.StudentJson;
import com.tikal.workshop.repository.StudentRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class StudentListener {

    final private StudentRepository studentRepository;
    final private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public StudentListener(
            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @KafkaListener(topics="students", groupId = "students", concurrency = "3")
    public void handle(ConsumerRecord<String, String> consumerRecord,
                       Acknowledgment acknowledgment) {
        try {
            StudentJson studentJson = objectMapper.readValue(consumerRecord.value(), StudentJson.class);

            Student student = studentJson.toEntity();
            studentRepository.save(student);
            acknowledgment.acknowledge();
        } catch (JsonProcessingException ignored) {
        }
    }
}

package com.tikal.workshop;

import com.tikal.workshop.app.WorkshopApplication;
import com.tikal.workshop.json.StudentJson;
import com.tikal.workshop.listener.StudentListener;
import com.tikal.workshop.repository.StudentRepository;
import com.tikal.workshop.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes = WorkshopApplication.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;
    @MockBean
    private StudentRepository studentRepository;
    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;
    @MockBean
    private StudentListener studentListener;

    @Test
    public void testPost() throws Exception {

        doNothing().when(studentService).save(new StudentJson("sigal"));
        mockMvc.perform(post("/student/")
                .contentType(APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isCreated());
    }
}
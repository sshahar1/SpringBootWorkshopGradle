package com.tikal.workshop;

import com.tikal.workshop.app.WorkshopApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO: Your test must pass
@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes = WorkshopApplication.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private StudentService studentService;

    @Test
    public void testPost() throws Exception {

        mockMvc.perform(post("/student/")
                .contentType(APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isCreated())
                .andExpect(content().string(is("1234")));
    }
}
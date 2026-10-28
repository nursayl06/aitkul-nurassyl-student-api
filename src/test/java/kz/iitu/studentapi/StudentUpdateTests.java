package kz.iitu.studentapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class StudentUpdateTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private StudentRepository repository;

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void updateStudentChangesGroup() throws Exception {
        Student s = new Student();
        s.setFirstName("Nurassyl");
        s.setLastName("Aitkul");
        s.setEmail("nurassyl.aitkul@example.com");
        s.setGroupName("IT2-2307");
        Long id = repository.save(s).getId();

        String json = """
                {"firstName":"Nurassyl","lastName":"Aitkul",
                 "email":"nurassyl.aitkul@example.com","groupName":"IT2-2307-UPDATED"}
                """;
        mvc.perform(put("/api/students/" + id).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.groupName").value("IT2-2307-UPDATED"));
    }

    @Test
    void updateUnknownStudentReturns404() throws Exception {
        String json = """
                {"firstName":"A","lastName":"B","email":"a.b@example.com","groupName":"X"}
                """;
        mvc.perform(put("/api/students/9999").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isNotFound());
    }
}

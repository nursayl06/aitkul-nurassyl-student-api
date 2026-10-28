package kz.iitu.studentapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
class StudentApiTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void createStudentAndGetAll() throws Exception {
        String json = """
                {"firstName":"Nurassyl","lastName":"Aitkul",
                 "email":"nurassyl.aitkul@example.com","groupName":"IT2-2307"}
                """;
        mvc.perform(post("/api/students").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.lastName").value("Aitkul"));
        mvc.perform(get("/api/students"))
                .andExpect(status().isOk());
    }

    @Test
    void unknownStudentReturns404() throws Exception {
        mvc.perform(get("/api/students/9999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void infoShowsStudentName() throws Exception {
        mvc.perform(get("/api/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.surname").value("Aitkul"))
                .andExpect(jsonPath("$.studentId").value("37375"));
    }
}

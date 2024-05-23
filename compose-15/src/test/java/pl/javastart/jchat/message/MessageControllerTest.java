package pl.javastart.jchat.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MessageControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldAddMessageAndRedirect() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/")
                        .param("author", "someAuthor")
                        .param("message", "some message")
                )
                .andExpectAll(
                        status().is3xxRedirection(),
                        redirectedUrl("/")
                );
    }
}
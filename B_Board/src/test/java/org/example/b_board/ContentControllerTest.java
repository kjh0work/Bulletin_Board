package org.example.b_board;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.b_board.entity.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ContentControllerTest {

    @Autowired
    private ContentRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Content 생성 성공")
    public void createContent() throws Exception {
        Content content  = Content.builder()
                .title("first write")
                .writer("jaehoon")
                .First_published_date(LocalDate.of(2020,4,5))
                .Last_update_date(LocalDate.of(2023,4,5))
                .build();

        this.repository.save(content);

        this.mockMvc.perform(post("/api/contents")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(content)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value("first write"))
                .andExpect(jsonPath("writer").exists())
                .andExpect(jsonPath("_links.self").exists())
        ;

    }
}
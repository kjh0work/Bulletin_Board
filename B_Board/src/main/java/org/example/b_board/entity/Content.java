package org.example.b_board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder @Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Content extends RepresentationModel<Content> {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String writer;

    private String article;
    private LocalDate First_published_date;
    private LocalDate Last_update_date;


}

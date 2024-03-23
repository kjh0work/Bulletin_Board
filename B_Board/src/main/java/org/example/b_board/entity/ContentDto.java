package org.example.b_board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class ContentDto {
    private String title;
    private String writer;

    private String article;
    private LocalDate First_published_date;
    private LocalDate Last_update_date;
}

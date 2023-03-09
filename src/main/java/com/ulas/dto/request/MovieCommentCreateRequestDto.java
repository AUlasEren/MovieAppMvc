package com.ulas.dto.request;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MovieCommentCreateRequestDto {
    private Long movieid;
    private Long userid;
    private String content;
}

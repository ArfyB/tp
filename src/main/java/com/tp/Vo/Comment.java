package com.tp.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data //get set
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment
{
    private String author;
    private String  content;
    private java.sql.Date created_at;
}

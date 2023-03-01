package com.tp.Vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data //get set
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    private String whatm;
    private String mname;
    private String weigh;
}
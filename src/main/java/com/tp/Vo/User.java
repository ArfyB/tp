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
public class User 
{
	private String uid;
	private String pwd;
	private int age;
	private String gender;
	private String spice;
	private String ft; // foodtype
}

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
public class User_info
{
	private String user_id;
	private String password;
	private int age;		// 나이
	private String gender;	// 성별
	private String country; // foodtype
	private String mg;
}

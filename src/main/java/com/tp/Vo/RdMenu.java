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
public class RdMenu 
{
	private String mg;			// 육식, 채식
	private String country;		// 한식, 일식, 양식, 중식, 그외
	private String mname;		// 요리이름
}

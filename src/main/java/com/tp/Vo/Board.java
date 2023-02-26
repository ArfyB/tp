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
public class Board
{
	private int bnum;  		// 시퀀스 레시피 번호	시퀀스 
	private String title;	// 레시피 제목			@
	private String author;	// 작성자				
	private int hits;		// 조회수
	private String contents;
	private java.sql.Date recdate;	// 작성일
	private String bpic;
}
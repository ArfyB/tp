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
public class Recipe 
{
	private int rnum;  		// 시퀀스 레시피 번호	시퀀스 
	private String title;	// 레시피 제목			@
	private String info;	// 요리소개			@
	private String author;	// 작성자				
	private int hits;		// 조회수				
	private java.sql.Date recdate;	// 작성일		
	private String category;	// 가장 큰 카테고리	@
	private String how;			// 방법			@ 11
	private String catemat;		// 주 재료		@ 11
	private String human;		// 몇인분			@
	private int time;		// 조리시간			@
	private String difficult;	// 난이도			@
	private int racc;		// 관리자승인여부
	private String rpic;	// 레시피 메인사진 이름
}
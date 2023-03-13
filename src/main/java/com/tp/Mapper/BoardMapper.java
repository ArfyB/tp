package com.tp.Mapper;

import java.util.List;
import java.util.Map;

import com.tp.Vo.Comment;
import org.apache.ibatis.annotations.Mapper;

import com.tp.Vo.Board;
import com.tp.Vo.BoardPic;

@Mapper
public interface BoardMapper
{
	public List<Map<String, Object>> AllBoard();
	public int BoardAdd(Board brd);
	public int BrdPicAdd(List<BoardPic> list);
	public Board GetBoard(int bnum);
	public List<Board> GetBoardHit();
	public List<Board> GetBoardBnum();
	public int uphit(int bnum);
    public List<Comment> Comment();

}

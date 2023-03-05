package com.tp.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tp.Vo.Board;
import com.tp.Vo.BoardPic;
import com.tp.Vo.User_info;

@Mapper
public interface UserMapper
{
	public int UserAdd(User_info ui);
	public User_info dologin(User_info ui);
}

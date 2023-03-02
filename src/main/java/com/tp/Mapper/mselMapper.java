package com.tp.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tp.Vo.RdMenu;

@Mapper
public interface mselMapper 
{
	public int mselAdd(RdMenu rm);
	public RdMenu getrdwithmg(RdMenu rm);
	public RdMenu getrd(RdMenu rm);
}

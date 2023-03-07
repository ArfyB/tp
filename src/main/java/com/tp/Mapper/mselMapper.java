package com.tp.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tp.Vo.RdMenu;

@Mapper
public interface mselMapper 
{
	public int mselAdd(RdMenu rm);
	public RdMenu getrdwithmg(RdMenu rm);
	public RdMenu getrd(RdMenu rm);
	public List<RdMenu> rmenu1(RdMenu rm);
	public List<RdMenu> rmenu2(RdMenu rm);
}

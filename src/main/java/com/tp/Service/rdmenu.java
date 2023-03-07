package com.tp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.Mapper.mselMapper;
import com.tp.Vo.RdMenu;

@Service
public class rdmenu 
{
	@Autowired
	public mselMapper mm;
	
	public boolean added(RdMenu rm)
	{
		return 0<mm.mselAdd(rm);
	}
	
	public RdMenu getrdwithmg(RdMenu rm)
	{
		return mm.getrdwithmg(rm);
	}
	
	public RdMenu getrd(RdMenu rm)
	{
		return mm.getrd(rm);
	}
	
	public List<RdMenu> rmenu1(RdMenu rm)
	{
		return mm.rmenu1(rm);
	}
	
	public List<RdMenu> rmenu2(RdMenu rm)
	{
		return mm.rmenu2(rm);
	}
}

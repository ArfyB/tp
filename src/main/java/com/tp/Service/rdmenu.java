package com.tp.Service;

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
}

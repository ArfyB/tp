package com.tp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.Mapper.UserMapper;
import com.tp.Vo.User_info;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService 
{
	@Autowired
	public UserMapper um;
	
	public boolean UserAdd(User_info ui) 
	{
		return 0 < um.UserAdd(ui);
	}
	
	public boolean dologin(User_info ui)
	{
		String uid = ui.getUser_id();
		String pwd = ui.getPassword();
		
		User_info ui2 = um.dologin(ui);
		
		if(uid.equals(ui2.getUser_id()))
		{
			if(pwd.equals(ui2.getPassword()))
			{
				return true;
			}
		}
		
		return false;
	}
	
}

package com.xworkz.matrimony.dao;

import com.xworkz.matrimony.dto.Bride;

public interface MatrimonyDAO {
	
	public Bride getById(int id);
	
	public void getAllBrides(Bride bride);
	
	public int create(Bride bride);
	
	public int updatePhoneNumberById(int id,String phoneNo);
	
	public int deleteBrideById(int id);

}

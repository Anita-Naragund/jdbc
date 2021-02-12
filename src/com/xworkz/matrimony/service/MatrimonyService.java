package com.xworkz.matrimony.service;

import com.xworkz.matrimony.dto.Bride;

public interface MatrimonyService {
	
	public Bride getBride(int id);
	
	public Bride getAllBrides(Bride bride);
	
	public int validateAndCreateBride(Bride bride);
	
	public int validateAndUpdatePhoneNoById(int id,String phoneNo);
	
	public int validateAndDeleteBrideById(int id);
	}

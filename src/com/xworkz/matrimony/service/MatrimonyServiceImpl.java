package com.xworkz.matrimony.service;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dto.Bride;

public class MatrimonyServiceImpl implements MatrimonyService {
	
	private MatrimonyDAO dao;
	public MatrimonyServiceImpl(MatrimonyDAO dao) {
		this.dao=dao;
	}

	@Override
	public Bride getBride(int id) {
		if(0==id) {
			System.out.println("Invalid id");
			return null;
		}
		return dao.getById(id);
	}

	@Override
	public Bride getAllBrides(Bride bride) {
		if(bride!=null) {
			dao.getAllBrides(bride);
		}else {
			System.out.println("Bride is null");
		}
		return bride;
	}

	@Override
	public int validateAndCreateBride(Bride bride) {
		if(null==bride) {
			System.out.println("Bride can not be null");
			return 0;
		}
		else if(bride.getId()==0) {
			System.out.println("Invalid ID");
			return 0;
		}else { 
			return dao.create(bride);
		}
	}

	@Override
	public int validateAndUpdatePhoneNoById(int id, String phoneNo) {
		if(id==0 && null==phoneNo) {
			System.out.println("ID and phoneNo is invalid");
			return 0;
		}else {
			return dao.updatePhoneNumberById(id, phoneNo);
		}
	}

	@Override
	public int validateAndDeleteBrideById(int id) {
		if(id==0) {
			System.out.println("ID is not valid");
			return 0;
		}else {
			return dao.deleteBrideById(id);
		}
	}

}

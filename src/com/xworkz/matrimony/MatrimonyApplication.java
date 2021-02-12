package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.Bride;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class MatrimonyApplication {

	public static void main(String[] args) {
		MatrimonyDAO dao = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService=new MatrimonyServiceImpl(dao);
		Bride bride = matrimonyService.getBride(2);
		//dao.getById(1);
		//System.out.println(bride);
		//dao.getAllBrides(bride);
		//matrimonyService.getBride(2);
		if(bride!=null) {
			System.out.println(bride);
		}
		
		//6Bride bride1=matrimonyService.getAllBrides(bride);

	}

}

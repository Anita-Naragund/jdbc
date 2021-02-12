package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.Bride;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class UpdateApplicationOfBride {

	public static void main(String[] args) {
		MatrimonyDAO dao=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(dao);
		Bride bride=new Bride();
		
		int updated=service.validateAndUpdatePhoneNoById(1, "9901463150");
		if(updated==1) {
			System.out.println("updated successfully...");
		}else {
			System.out.println("Failed to update....");
		}

		service.getBride(1);
	}

}

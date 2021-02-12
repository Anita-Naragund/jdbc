package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.Bride;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class MatrimonyGetAllBrides {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MatrimonyDAO dao = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService=new MatrimonyServiceImpl(dao);
		
		Bride bride=new Bride();
		 
		matrimonyService.getAllBrides(bride);
	}

}

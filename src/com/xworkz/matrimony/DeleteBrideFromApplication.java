package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.Bride;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class DeleteBrideFromApplication {

	public static void main(String[] args) {
		MatrimonyDAO dao=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(dao);
		Bride bride=new Bride();
		int deleted=service.validateAndDeleteBrideById(3);
		if(deleted==1) {
			System.out.println("deleted Successfully....");
		}else {
			System.out.println("failed to delete");
		}
		service.getAllBrides(bride);
	}

}

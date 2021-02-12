package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.Bride;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class CreateBrideApplication {
	public static void main(String[] args) {
		
		MatrimonyDAO dao=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(dao);
		Bride bride=new Bride();
		
		bride.setId(6);
		bride.setName("Vidya");
		bride.setAge(20);
		bride.setHeight(4.9);
		bride.setWeight(45);
		bride.setQualification("BE");
		bride.setExpectation("Good Salary");
		bride.setPhoneNo("8746985241");
		bride.setSalary(250000);
		bride.setOccupation("Student");
		bride.setAddress("Gadag");
		
		int created=service.validateAndCreateBride(bride);
		if(created==1) {
			System.out.println("Bride created succefully......");
		}else {
			System.out.println("Failed to create Bride...");
			
			//UPDATE Registration " +
           // "SET age = 30 WHERE id in (100, 101)
		}
	}

}

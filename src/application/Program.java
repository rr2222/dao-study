package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller obj1 = sellerDao.findById(3);
		System.out.println(obj1);
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		//list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new Id = " + newSeller.getId());
	}
	

}

package com.phase3.project;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import com.phase3.project.Entity.Product;
import com.phase3.project.Entity.Productorder;
import com.phase3.project.Entity.User;
import com.phase3.project.Repository.OrderRepository;
import com.phase3.project.Service.OrderService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class OrderTest {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testOrder() {
		Product pd=entityManager.find(Product.class, 10);
		User us=entityManager.find(User.class, 4);
		Productorder order=new Productorder();
		System.out.println("product_id :" + pd.getProductid());
		order.setProduct(pd); 
		order.setUser(us);
		order.setQuantity(2);
		
		order.setOrderdate(new Date());
		
		Productorder od=orderRepository.save(order);
		
		assertTrue(od.getOrderid() >0);
		
	}
}

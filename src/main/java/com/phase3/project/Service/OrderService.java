package com.phase3.project.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.phase3.project.Entity.Product;
import com.phase3.project.Entity.Productorder;
import com.phase3.project.Entity.User;
import com.phase3.project.Repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public  void save(Productorder order)
	{
		orderRepository.save(order);
	}

    public List<Productorder> getByUser(User user){
		List<Productorder> orders= orderRepository.findByUser(user);
		return orders;
	}
	
	public Productorder getByUserAndProduct(User user,Product product) {
		Productorder order=orderRepository.findByUserAndProduct(user, product);
		return order; 
	}
	
	public List<Productorder> getAllOrders(){
		List<Productorder> orders= orderRepository.findAll();
		return orders;
	}
	
	public List<Productorder> getByProductBrandlike(String keyword){
		List<Productorder> orders= orderRepository.findByProductBrandlike(keyword);
		return orders;
	}
	
	public List<Productorder> getByOrderdatelike(Date date){
		List<Productorder> orders= orderRepository.findByOrderdate(date);
		return orders;
	}
}


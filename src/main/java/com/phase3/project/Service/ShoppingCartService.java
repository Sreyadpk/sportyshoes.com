package com.phase3.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phase3.project.Entity.Cartitems;
import com.phase3.project.Entity.Product;
import com.phase3.project.Entity.User;
import com.phase3.project.Repository.CartitemsRepository;

@Service
@Transactional
public class ShoppingCartService {

	@Autowired
	private CartitemsRepository cartitemsRepository;
	
	public  void save(Cartitems cartitems)
	{
		cartitemsRepository.save(cartitems);
	}
	
	public void deleteById(int id) {
		cartitemsRepository.deleteById(id);
	} 
	
	public List<Cartitems> getByUser(User user){
		List<Cartitems> cartitems= cartitemsRepository.findByUser(user);
		return cartitems;
	}
	
	public Cartitems getByUserAndProduct(User user,Product product) {
		Cartitems cart=cartitemsRepository.findByUserAndProduct(user, product);
		return cart;
	}
}

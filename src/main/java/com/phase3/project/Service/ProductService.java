package com.phase3.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phase3.project.Entity.Product;
import com.phase3.project.Repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public void save(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> listAll() {
        return productRepository.findAll();
    }
	
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}
	
	public Product getById(int id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}

	public void update(Product product) {
		productRepository.save(product);
	}
}

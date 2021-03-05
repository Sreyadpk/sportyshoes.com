package com.phase3.project.Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phase3.project.Entity.Product;
import com.phase3.project.Entity.Productorder;
import com.phase3.project.Entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Productorder,Integer> {
	public List<Productorder> findByUser(User user);
	public Productorder findByUserAndProduct(User user,Product product);
	
	@Query("SELECT p FROM Productorder p WHERE p.product.productbrand like %?1%")
	public List<Productorder> findByProductBrandlike(String keyword);
	
	public List<Productorder> findByOrderdate(Date date);
}

package com.phase3.project.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phase3.project.Entity.Cartitems;
import com.phase3.project.Entity.Product;
import com.phase3.project.Entity.User;

@Repository
public interface CartitemsRepository extends CrudRepository<Cartitems, Integer>  {
    public List<Cartitems> findByUser(User user);
    public Cartitems findByUserAndProduct(User user,Product product);
    
}

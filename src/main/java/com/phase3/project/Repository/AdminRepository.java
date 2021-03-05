package com.phase3.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phase3.project.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}

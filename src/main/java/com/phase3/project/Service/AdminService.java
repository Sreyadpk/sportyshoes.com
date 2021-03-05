package com.phase3.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phase3.project.Entity.Admin;
import com.phase3.project.Repository.AdminRepository;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public void save(Admin admin) {
		adminRepository.save(admin);
	}
	public Admin findById(int id) {
		Optional<Admin> bk = adminRepository.findById(id);
		return bk.get();
	}

}

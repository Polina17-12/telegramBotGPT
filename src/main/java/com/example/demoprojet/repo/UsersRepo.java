package com.example.demoprojet.repo;

import com.example.demoprojet.entity.infoUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<infoUsers, Long> {

}

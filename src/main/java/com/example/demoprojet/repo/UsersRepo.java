package com.example.demoprojet.repo;

import com.example.demoprojet.entity.InfoUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<InfoUsers, Long> {
     Optional<InfoUsers> findByUserIdInTg(long id);
}

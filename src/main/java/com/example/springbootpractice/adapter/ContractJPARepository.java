package com.example.springbootpractice.adapter;

import com.example.springbootpractice.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractJPARepository extends JpaRepository<Contract,Long> {
    Optional<Contract> findById(Long id);
}

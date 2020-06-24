package com.example.springbootpractice.adapter;

import com.example.springbootpractice.domain.Contract;
import com.example.springbootpractice.domain.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ContractJPAAdapter implements ContractRepository {
    @Autowired
    ContractJPARepository repo;

    @Override
    public Optional<Contract> findById(Long id) {
        return repo.findById(id);
    }
}

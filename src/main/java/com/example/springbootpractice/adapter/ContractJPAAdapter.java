package com.example.springbootpractice.adapter;

import com.example.springbootpractice.domain.Contract;
import com.example.springbootpractice.domain.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ContractJPAAdapter implements ContractRepository {
    @Autowired
    ContractJPARepository repo;

    @Override
    public ArrayList<Contract> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Long save(Contract data) {
        return repo.save(data).getId();
    }
}

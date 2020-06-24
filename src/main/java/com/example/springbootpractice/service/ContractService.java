package com.example.springbootpractice.service;

import com.example.springbootpractice.domain.Contract;
import com.example.springbootpractice.domain.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContractService implements IContractService{

    @Autowired
    ContractRepository repo;

    @Override
    public ArrayList<Contract> getContract() {
        return null;
    }

    @Override
    public Contract findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public String create() {
        return null;
    }
}

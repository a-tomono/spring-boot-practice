package com.example.springbootpractice.adapter;

import com.example.springbootpractice.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.invoke.ConstantBootstraps;
import java.util.ArrayList;
import java.util.Optional;

public interface ContractJPARepository extends JpaRepository<Contract, Long> {

    @Override
    ArrayList<Contract> findAll();

    @Override
    Optional<Contract> findById(Long id);

    @SuppressWarnings("unchecked")
    @Override
    Contract save(Contract data);

}

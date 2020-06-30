package com.example.springbootpractice.domain;

import java.util.ArrayList;
import java.util.Optional;

public interface ContractRepository {

    ArrayList<Contract> findAll();
    Optional<Contract> findById(Long id);
    Long save(Contract data);
}

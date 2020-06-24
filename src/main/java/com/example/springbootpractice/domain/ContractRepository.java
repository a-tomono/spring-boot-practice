package com.example.springbootpractice.domain;

import java.util.Optional;

public interface ContractRepository {

    Optional<Contract> findById(Long id);
}

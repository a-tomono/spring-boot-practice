package com.example.springbootpractice.service;

import com.example.springbootpractice.domain.Contract;

import java.util.ArrayList;

public interface IContractService {

    ArrayList<Contract> getContract();

    Contract findById(Long id);

    String create();

}

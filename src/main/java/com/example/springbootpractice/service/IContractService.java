package com.example.springbootpractice.service;

import java.util.ArrayList;

public interface IContractService {

    ArrayList<ContractDto> getContract();

    ContractDto findById(Long id);

    Long create(ContractCreateCommand contract);

}

package com.example.springbootpractice.service;

import com.example.springbootpractice.command.ContractCreateCommand;
import com.example.springbootpractice.command.ContractDraftCommand;

import java.util.ArrayList;

public interface IContractService {

    ArrayList<ContractDto> getContract();

    ContractDto findById(Long id);

    Long create(ContractCreateCommand command);

    Long draft(Long id, ContractDraftCommand command);

}

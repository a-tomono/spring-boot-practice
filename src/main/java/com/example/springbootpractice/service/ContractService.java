package com.example.springbootpractice.service;

import com.example.springbootpractice.command.ContractCreateCommand;
import com.example.springbootpractice.command.ContractDraftCommand;
import com.example.springbootpractice.domain.Contract;
import com.example.springbootpractice.domain.ContractRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContractService implements IContractService {

    @Autowired
    ContractRepository repo;

    @Override
    public ArrayList<ContractDto> getContract() {
        return null;
    }

    @Override
    public ContractDto findById(Long id) {
        Contract result = repo.findById(id).orElseThrow();
        ContractDto dto = new ContractDto();
        BeanUtils.copyProperties(result, dto);
        return dto;
    }

    @Override
    public Long create(ContractCreateCommand command) {
        Contract target = new Contract(
                command.getContractName(),
                command.getContractAbstract());
        return repo.save(target);
    }

    @Override
    public Long draft(Long id, ContractDraftCommand command) {
        Contract target = repo.findById(id).orElseThrow();
        target.draft(command.getContractName(), command.getContractAbstract());
        return repo.save(target);
    }
}

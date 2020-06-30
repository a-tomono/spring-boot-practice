package com.example.springbootpractice.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContractCreateCommand {
    private String contractName;
    private String contractAbstract;

    public ContractCreateCommand(String contractName, String contractAbstract) {
        this.contractName = contractName;
        this.contractAbstract = contractAbstract;
    }
}

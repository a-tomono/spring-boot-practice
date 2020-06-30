package com.example.springbootpractice.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContractCreateCommand implements Serializable {
    private String contractName;
    private String contractAbstract;
}

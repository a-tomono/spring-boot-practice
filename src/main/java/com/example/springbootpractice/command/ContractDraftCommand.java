package com.example.springbootpractice.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContractDraftCommand {
    private String contractName;
    private String contractAbstract;
}

package com.example.springbootpractice.service;

import com.example.springbootpractice.domain.ContractStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@Component
@NoArgsConstructor
public class ContractDto {
    private Long id;
    private String contractName;
    private String contractAbstract;
    //   private Person kou;
    //   private Person otsu;
    private LocalDate createDate;
    private LocalDate draftDate;
    private LocalDate reviewedDate;
    private LocalDate conclusionDate;
    private ContractStatus status;

}

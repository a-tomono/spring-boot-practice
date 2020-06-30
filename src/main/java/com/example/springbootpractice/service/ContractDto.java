package com.example.springbootpractice.service;

import com.example.springbootpractice.domain.ContractStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Component
@NoArgsConstructor
public class ContractDto implements Serializable {
    private Long id;
    private String contractName;
    private String contractAbstract;
    //   private Person kou;
    //   private Person otsu;
    private LocalDateTime createDate;
    private LocalDateTime draftDate;
    private LocalDateTime reviewedDate;
    private LocalDateTime conclusionDate;
    private ContractStatus status;

}

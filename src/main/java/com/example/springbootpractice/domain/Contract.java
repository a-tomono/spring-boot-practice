package com.example.springbootpractice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contractName;
    private String contractAbstract;
    //   private Person kou;
    //   private Person otsu;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime draftDate;
    private LocalDateTime reviewedDate;
    private LocalDateTime conclusionDate;
    @Enumerated(EnumType.STRING)
    private ContractStatus status = ContractStatus.INITIALIZED;

    public Contract(String contractName, String contractAbstract) {
        this.contractName = contractName;
        this.contractAbstract = contractAbstract;
    }

    public void draft(String contractName, String contractAbstract) {
        if (isConclusion()) {
            throw new RuntimeException("can not draft signed contract");
        } else {
            this.contractName = contractName;
            this.contractAbstract = contractAbstract;
            status = ContractStatus.DRAFT;
            draftDate = LocalDateTime.now();
        }
    }

    public void review() {
        if (isDraft()) {
            status = ContractStatus.REVIEWED;
            reviewedDate = LocalDateTime.now();
        } else {
            throw new RuntimeException("can not review this contract");
        }
    }

    public void sign() {
        if (isReviewed()) {
            status = ContractStatus.CONCLUSION;
            conclusionDate = LocalDateTime.now();
        } else {
            throw new RuntimeException("can not conclusion this contract");
        }
    }

    public boolean isDraft() {
        return status.equals(ContractStatus.DRAFT);
    }

    public boolean isReviewed() {
        return status.equals(ContractStatus.REVIEWED);
    }

    public boolean isConclusion() {
        return status.equals(ContractStatus.CONCLUSION);
    }

}

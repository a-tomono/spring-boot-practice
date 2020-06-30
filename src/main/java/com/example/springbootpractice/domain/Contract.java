package com.example.springbootpractice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contractName;
    private String contractAbstract;
    //   private Person kou;
    //   private Person otsu;
    private LocalDate createDate = LocalDate.now();
    private LocalDate draftDate;
    private LocalDate reviewedDate;
    private LocalDate conclusionDate;
    private ContractStatus status = ContractStatus.INITIALIZED;

    public Contract(String contractName, String contractAbstract) {
        this.contractName = contractName;
        this.contractAbstract = contractAbstract;
    }

    public void draft() {
        if (isConclusion()) {
            throw new RuntimeException("can not draft signed contract");
        } else {
            status = ContractStatus.DRAFT;
            draftDate = LocalDate.now();
        }
    }

    public void review() {
        if (isDraft()) {
            status = ContractStatus.REVIEWED;
            reviewedDate = LocalDate.now();
        } else {
            throw new RuntimeException("can not review this contract");
        }
    }

    public void sign() {
        if (isReviewed()) {
            status = ContractStatus.CONCLUSION;
            conclusionDate = LocalDate.now();
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

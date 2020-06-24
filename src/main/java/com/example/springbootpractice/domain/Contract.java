package com.example.springbootpractice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
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
    private LocalDate draftDate;
    private LocalDate reviewedDate;
    private LocalDate conclusionDate;
    private ContractStatus status = ContractStatus.INITIALIZED;

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
        if (status.equals(ContractStatus.DRAFT)) return true;
        return false;
    }

    public boolean isReviewed() {
        if (status.equals(ContractStatus.REVIEWED)) return true;
        return false;
    }

    public boolean isConclusion() {
        if (status.equals(ContractStatus.CONCLUSION)) return true;
        return false;
    }

}

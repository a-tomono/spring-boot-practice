package com.example.springbootpractice.domain

import spock.lang.Specification

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset


class ContractSpec extends Specification {

    def "作成した契約を編集して下書きする"() {
        given:
        def contract = new Contract("name", "abst")
        def modifiedName = "drafted name"
        def modifiedAbstract = "drafted abst"

        expect:
        contract.draft(modifiedName, modifiedAbstract)
        contract.getContractName().equals(modifiedName)
        contract.getContractAbstract().equals(modifiedAbstract)
        contract.isDraft()
    }

    def "複数回下書きすると日付が更新される"() {
        given:
        def contract = new Contract()
        def modifiedName = "name"
        def anotherModifiedName = "another name"
        def modifiedAbstract = "abst"
        def anotherModifiedAbstract = "another abst"

        when:
        contract.draft(modifiedName, modifiedAbstract)
        def firstDraftDateTime = contract.getDraftDate()
        contract.draft(anotherModifiedName, anotherModifiedAbstract)

        then:
        contract.getContractName().equals(anotherModifiedName)
        contract.getContractAbstract().equals(anotherModifiedAbstract)
        contract.getDraftDate().isAfter(firstDraftDateTime)
    }

    def "下書きをレビューする"() {
        given:
        def contract = new Contract()
        contract.draft("draftName", "draftAbstract")

        expect:
        contract.review()
        contract.isReviewed()
    }

    def "作成した初期状態はレビューできない"() {
        setup:
        def contract = new Contract()

        when:
        contract.review()

        then:
        def e = thrown(RuntimeException.class)
        e.class == RuntimeException.class
        e.message == "can not review this contract"
    }
}
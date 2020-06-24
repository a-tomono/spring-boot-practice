package com.example.springbootpractice.domain

import spock.lang.Specification


class ContractSpec extends Specification {

    def "ドラフトをレビューする"(){
        given:
        def contract = new Contract();
        contract.draft();

        when:
        contract.review();

        then:
        contract.isReviewed();
    }
}
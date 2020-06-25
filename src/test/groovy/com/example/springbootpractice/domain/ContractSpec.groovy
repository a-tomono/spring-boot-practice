package com.example.springbootpractice.domain

import spock.lang.Specification


class ContractSpec extends Specification {

    def "ドラフトをレビューする"(){
        given:
        def contract = new Contract();
        contract.draft();

        expect:
        contract.review();
        contract.isReviewed();

    }

    def "初期状態はレビューできない"(){
        setup:
        def contract = new Contract();

        when:
        contract.review();

        then:
        def e = thrown(RuntimeException.class);
        e.class == RuntimeException.class;
        e.message == "can not review this contract";
    }
}
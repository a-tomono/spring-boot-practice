package com.example.springbootpractice.api;

import com.example.springbootpractice.service.ContractCreateCommand;
import com.example.springbootpractice.service.ContractDto;
import com.example.springbootpractice.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ContractRestController {

    @Autowired
    IContractService service;

    @GetMapping("/contracts")
    public ResponseEntity getContracts(){
        ArrayList<ContractDto> result = service.getContract();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/contracts/{id}")
    public ResponseEntity getContractById(@PathVariable("id") Long id){
        ContractDto contract = service.findById(id);
        return new ResponseEntity<>(contract,HttpStatus.OK);
    }

    @PostMapping("/contracts")
    public Long createContract(@RequestBody ContractCreateCommand contract){
        return service.create(contract);
    }
}

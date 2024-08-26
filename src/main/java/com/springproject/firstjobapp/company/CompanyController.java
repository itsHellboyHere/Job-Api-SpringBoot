package com.springproject.firstjobapp.company;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Created SuccessFully",HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCompanyById(@PathVariable Long id){
        Company company= companyService.getCompanyById(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        return new ResponseEntity<>("No company with id "+id+ " is found.",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company updatedCompany){
        boolean update= companyService.updateCompany(id,updatedCompany);
        return update?ResponseEntity.ok("Company Updated Successfully!"):new ResponseEntity<>("No company with id "+id+ " is found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean delete= companyService.deleteCompany(id);
        if(delete){
            return new ResponseEntity<>("Company deleted.",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No company with id "+id+" is found",HttpStatus.NOT_FOUND);
        }
    }
}

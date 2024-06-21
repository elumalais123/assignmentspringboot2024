package com.cts.core.assignment.empauto;


import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	

    @Autowired
    private Address empaddress;

    public Address getEmpaddress() {
        return empaddress;
    }
    public void setEmpaddress(Address empaddress) {
        this.empaddress = empaddress;
    }
}
package com.nesan.ecommerce.nesanclasses;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

public class Customer {
   
    private int age;
    @NotBlank(message = "*  fill required field")
    private String name;
    @NotBlank(message = "*  fill required field")
    private String address;
    @Size(min =6, max=6, message="* pincode not valid must be 6 digits")
    private String pincode;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    @Override
    public String toString() {
        return "Customer [address=" + address + ", age=" + age + ", name=" + name + ", pincode=" + pincode + "]";
    }

}

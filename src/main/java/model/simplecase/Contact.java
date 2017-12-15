package model.simplecase;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.text.DecimalFormat;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Contact {

    private static DecimalFormat decimalFormat = new DecimalFormat("###.##");

    private String firstName;
    private String name;
    private String phoneNumber;
    private int age;
    private String address;
    @JacksonXmlProperty(localName = "account_ammount")
    private Double account;

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    @JsonGetter("age")
    @JacksonXmlProperty(isAttribute = true, localName = "civil_age")
    public String getHumanReadableAge(){
        return String.valueOf(this.age) + " years";
    }

    @JsonGetter("account")
    @JacksonXmlProperty(localName = "account_ammount")
    public String getDoubleValue(){
        return decimalFormat.format(this.account);
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public Double getAccount() {
        return account;
    }
}

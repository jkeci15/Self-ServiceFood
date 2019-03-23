package model;

public class Business {
    private int id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String cvr;
    private String bankaccount;
    private String mobilepay;
    private String phonenumber;
    private String logo;

    public Business(int id, String name, String address, String city, String country, String cvr, String bankaccount, String mobilepay, String phonenumber, String logo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.cvr = cvr;
        this.bankaccount = bankaccount;
        this.mobilepay = mobilepay;
        this.phonenumber = phonenumber;
        this.logo = logo;
    }

    public int getId() {
        return id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getMobilepay() {
        return mobilepay;
    }

    public void setMobilepay(String mobilepay) {
        this.mobilepay = mobilepay;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

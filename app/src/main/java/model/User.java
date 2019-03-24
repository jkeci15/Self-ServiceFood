package model;

public class User {
    private int id;
    private String email;
    private String name;
    private String surname;
    private String password;
    private int type;
    /*
    TODO: Discuss whether to save type as int or char or String?
    User types:
    1- manager
    2- staff
    3- customer
     */
    private String picture;
    private int business_id;

    public User(int id,String email, String name, String surname, String password, int type, String picture, int business_id) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.type = type;
        this.picture = picture;
        this.business_id = business_id;
        this.id = id;
    }
    public User(){

    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }
}

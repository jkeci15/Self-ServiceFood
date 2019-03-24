package model;

public class Category{
    private int id;

    private int business_id;
    private String name;

    public Category(int id, int business_id, String name) {
        this.id = id;
        this.business_id = business_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

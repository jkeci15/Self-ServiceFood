package model;

public class Item {
    private int id;
    private int business_id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private String picture;
    private int category_id;

    public Item(int id, int business_id, String name, int quantity, double price, String description, String picture, int category_id) {
        this.id = id;
        this.business_id = business_id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.picture = picture;
        this.category_id = category_id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}

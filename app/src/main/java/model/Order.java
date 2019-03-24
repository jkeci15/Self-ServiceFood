package model;

import java.sql.Timestamp;

public class Order {
    private int id;
    private Timestamp time;
    private int user_id;
    private int business_id;
    private double total;
    private int state;
    /*
    TODO: Discuss whether to save state as int or char or String?
    Order states:
    1- pending
    2- processing
    3- ready
    4- cancelled
     */

    public Order(int id, Timestamp time, int user_id, int business_id, double total, int state) {
        this.id = id;
        this.time = time;
        this.user_id = user_id;
        this.business_id = business_id;
        this.total = total;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

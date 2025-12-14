package com.project.vmeal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String mealName;
    private int durationDays;
    private double price;
    private String startDate;     

    public Subscription() {}

    public Subscription(String customerName, String mealName, int durationDays, double price, String startDate) {
        this.customerName = customerName;
        this.mealName = mealName;
        this.durationDays = durationDays;
        this.price = price;
        this.startDate = startDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getMealName() { return mealName; }
    public void setMealName(String mealName) { this.mealName = mealName; }

    public int getDurationDays() { return durationDays; }
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
}

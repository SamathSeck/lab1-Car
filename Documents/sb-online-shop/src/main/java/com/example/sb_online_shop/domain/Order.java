package com.example.sb_online_shop.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double total;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "custemer_id")
    private Custemer custemer;

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Item> items;

    // Constructors
    public Order() {}

    public Order(int id, double total, Date createdAt, Date updatedAt, Custemer custemer, List<Item> items) {
        this.id = id;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.custemer = custemer;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Custemer getCustemer() {
        return custemer;
    }

    public void setCustemer(Custemer custemer) {
        this.custemer = custemer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    // Getters and Setters
    // (Add the getters and setters here)
    
}

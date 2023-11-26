package com.fortalsoft.grocery.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = "groceryList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroceryItem> item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<GroceryItem> getItem() {
        return item;
    }

    public void setItem(List<GroceryItem> item) {
        this.item = item;
    }
}

package com.therawsingh.portfolio.entity.todoList;

import com.therawsingh.portfolio.entity.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String listName;

    @OneToMany
    private List<Items> items;

    public TodoList() {
    }

    public TodoList(User user, String listName, List<Items> items) {
        this.user = user;
        this.listName = listName;
        this.items = items;
    }

    public TodoList(Long id, User user, String listName, List<Items> items) {
        this.id = id;
        this.user = user;
        this.listName = listName;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}

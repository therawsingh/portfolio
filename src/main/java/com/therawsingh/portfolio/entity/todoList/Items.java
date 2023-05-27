package com.therawsingh.portfolio.entity.todoList;

import jakarta.persistence.*;

@Entity
public class Items {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private boolean state;

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;

    public Items() {
    }

    public Items(String description, boolean state, TodoList todoList) {
        this.description = description;
        this.state = state;
        this.todoList = todoList;
    }

    public Items(Long id, String description, boolean state, TodoList todoList) {
        this.id = id;
        this.description = description;
        this.state = state;
        this.todoList = todoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }
}

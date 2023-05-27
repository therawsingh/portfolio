package com.therawsingh.portfolio.repository;

import com.therawsingh.portfolio.entity.todoList.TodoList;
import com.therawsingh.portfolio.entity.url.Url;
import com.therawsingh.portfolio.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {

    public TodoList findByUser(User user);

}
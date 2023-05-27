package com.therawsingh.portfolio.repository;

import com.therawsingh.portfolio.entity.todoList.Items;
import com.therawsingh.portfolio.entity.url.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Long> {



}
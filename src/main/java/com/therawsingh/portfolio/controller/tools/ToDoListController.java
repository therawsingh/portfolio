package com.therawsingh.portfolio.controller.tools;

import com.therawsingh.portfolio.entity.todoList.Items;
import com.therawsingh.portfolio.entity.todoList.TodoList;
import com.therawsingh.portfolio.entity.user.User;
import com.therawsingh.portfolio.repository.ItemsRepository;
import com.therawsingh.portfolio.repository.TodoListRepository;
import com.therawsingh.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/todo")
public class ToDoListController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @GetMapping("/add")
    public void addList(OAuth2AuthenticationToken authentication){

        OAuth2User oAuth2User = authentication.getPrincipal();

        User user = userRepository.findByName(oAuth2User.getAttribute("name"));

        TodoList todoList = new TodoList();

        todoList.setUser(user);

        todoList.setListName("First List");

        Items item1 = new Items();
        Items item2 = new Items();

        item1.setDescription("Item 1");
        item1.setState(false);

        item2.setDescription("Item 1");
        item2.setState(false);

        ArrayList<Items> items = new ArrayList<>();

        items.add(item1);
        items.add(item2);

        todoListRepository.save(todoList);

        System.out.println("List created, items added");

    }

}

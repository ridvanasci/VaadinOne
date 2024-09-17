package com.example.vaadinone;

import com.example.vaadinone.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private final MenuRepository menuRepository;
    @Autowired
    private final UserRepository userRepository;

    public MyController(UserRepository userRepository, MenuRepository menuRepository) {
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
    }

    @GetMapping("/hello")
    public List<Menu> hello() {
        return menuRepository.findAll();
    }
    @GetMapping("/users")
    public List<User> users() {
        return userRepository.findAll();
    }
}
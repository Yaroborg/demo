package com.codewithmosh.afanasiev.controller;
import com.codewithmosh.afanasiev.repository.User;
import com.codewithmosh.afanasiev.service.UserSevice;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserSevice userSevice;

    public UserController(UserSevice userSevice) {

        this.userSevice = userSevice;
    }

    @GetMapping
    public List<User> findAll() {

        return userSevice.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {

        return userSevice.save(user);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id) {

        userSevice.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        userSevice.update(id, user.getName(), user.getEmail(),
                user.getBirthDate() != null ? user.getBirthDate().toString() : null);
    }



}

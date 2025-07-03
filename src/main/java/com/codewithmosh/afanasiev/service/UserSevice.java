package com.codewithmosh.afanasiev.service;
import com.codewithmosh.afanasiev.repository.User;
import com.codewithmosh.afanasiev.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class UserSevice {

    private final UserRepository userRepository;

    public UserSevice(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {

        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("User with email " + user.getEmail() + " already exists");
        }
        user.setAge(Period.between(user.getBirthDate(), LocalDate.now()).getYears());
        return userRepository.save(user);
    }

    public void delete(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("User with id " + id + " does not exist одын");
        }
        userRepository.deleteById(id);

    }

    public void update(Long id, String name, String email, String birthDate) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("User with id " + id + " does not exist два");
        }

        User user = optionalUser.get();

        if (email != null && !email.equals(user.getEmail())) {
            Optional<User> optionalUserByEmail = userRepository.findByEmail(email);
            if (optionalUserByEmail.isPresent()) {
                throw new IllegalStateException("User with email " + email + " already exists три");
            }
            user.setEmail(email);
        }

        if (name != null && !name.equals(user.getName())) {
            user.setName(name);
        }

        System.out.println("Old age: " + user.getAge());
        if (birthDate != null && !birthDate.equals(user.getBirthDate().toString())) {
            LocalDate parsedBirthDate = LocalDate.parse(birthDate);
            user.setBirthDate(parsedBirthDate);
            int newAge = Period.between(parsedBirthDate, LocalDate.now()).getYears();
            user.setAge(newAge);
            System.out.println("New age: " + newAge);
        }
        userRepository.save(user);
    }


}

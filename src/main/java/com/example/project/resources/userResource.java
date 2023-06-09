package com.example.project.resources;

import com.example.project.entities.User;
import com.example.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class userResource {

    @Autowired
    UserService service;

    // método que retorna uma lista de usuários do banco de dados
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    // método para buscar usuário pelo id
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = service.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user.get());
    }
}

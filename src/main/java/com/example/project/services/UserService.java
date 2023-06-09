package com.example.project.services;

import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    final private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // método que retorna uma lista de usuários do banco de dados
    public List<User> findAll() {
        return repository.findAll();
    }

    // método para buscar usuário pelo id
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }
}

package com.example.project.services;


import com.example.project.entities.Category;
import com.example.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    // método para listar todas as categorias
    public List<Category> findAll() { return repository.findAll(); }

    // método para buscar categoria pelo id
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }
}

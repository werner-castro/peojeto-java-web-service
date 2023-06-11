package com.example.project.services;

import com.example.project.entities.Product;
import com.example.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    final private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // método para listar todos os produtos
    public List<Product> findAll() { return repository.findAll(); }

    // método para buscar produto pelo id
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}

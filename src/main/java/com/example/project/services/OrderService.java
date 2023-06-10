package com.example.project.services;

import com.example.project.entities.Order;
import com.example.project.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    // método para listar todos os pedidos
    public List<Order> findAll() { return repository.findAll(); }

    // método para buscar pedido pelo id
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }
}

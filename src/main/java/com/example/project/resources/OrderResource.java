package com.example.project.resources;

import com.example.project.entities.Order;
import com.example.project.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    // método que retorna uma lista de pedidos do banco de dados
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = service.findAll();
        return ResponseEntity.ok().body(orders);
    }

    // método para buscar pedidos pelo id
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Optional<Order> order = service.findById(id);
        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(order.get());
    }

}

package com.example.project.resources;


import com.example.project.entities.Category;
import com.example.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    // método que retorna uma lista de categorias do banco de dados
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }

    // método para buscar categorias pelo id
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> category = service.findById(id);
        if (category.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(category.get());
    }

}

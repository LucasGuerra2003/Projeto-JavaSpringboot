package com.example.firebase.springbootfirebasedemo.controller;

import com.example.firebase.springbootfirebasedemo.Entity.Cliente;
import com.example.firebase.springbootfirebasedemo.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ProductService productService;

    @PostMapping("/cliente")
    public String setID(@RequestBody Cliente cliente) throws ExecutionException, InterruptedException {
        return productService.setID(cliente);
    }

    @GetMapping("/cliente/{id}")
    public Cliente getID(@PathVariable String id) throws ExecutionException, InterruptedException {
        return productService.getClienteDetailsByname(id);
    }

    @GetMapping("/cliente")
    public List<Cliente> getAllCliente() throws ExecutionException, InterruptedException {
        return productService.getClienteDetails();
    }

    @PutMapping("/cliente")
    public String update(@RequestBody Cliente cliente) throws ExecutionException, InterruptedException {
        return productService.updateCliente(cliente);
    }

    @DeleteMapping("/cliente/{id}")
    public String deletaCliente(@PathVariable String id) throws ExecutionException, InterruptedException {
        return productService.deletaCliente(id);
    }
}

package com.example.firebase.springbootfirebasedemo.controller;

import com.example.firebase.springbootfirebasedemo.Entity.Cliente;
import com.example.firebase.springbootfirebasedemo.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public String setID(@RequestBody Cliente cliente) throws ExecutionException, InterruptedException {
        return clienteService.setID(cliente);
    }

    @GetMapping("/cliente/{id}")
    public Cliente getID(@PathVariable String id) throws ExecutionException, InterruptedException {
        return clienteService.getClienteDetailsByid(id);
    }

    @PutMapping("/cliente")
    public String update(@RequestBody Cliente cliente) throws ExecutionException, InterruptedException {
        return clienteService.updateCliente(cliente);
    }

    @DeleteMapping("/cliente/{id}")
    public String deletaCliente(@PathVariable String id) throws ExecutionException, InterruptedException {
        return clienteService.deletaCliente(id);
    }
}

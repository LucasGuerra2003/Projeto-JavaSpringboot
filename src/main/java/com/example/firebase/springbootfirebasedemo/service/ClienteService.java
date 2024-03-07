package com.example.firebase.springbootfirebasedemo.service;

import com.example.firebase.springbootfirebasedemo.Entity.Cliente;
import com.example.firebase.springbootfirebasedemo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

import java.util.concurrent.ExecutionException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public String setID(Cliente cliente) throws ExecutionException, InterruptedException {
        validarCampos(cliente);
        Cliente existingCliente = clienteRepository.findById(cliente.getID());
        if (existingCliente == null) {
            return clienteRepository.save(cliente);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Frete com ID já existente.");
        }
    }

    public Cliente getClienteDetailsByid(String id) throws ExecutionException, InterruptedException {
        if (id != null) {
            return clienteRepository.findById(id);
        } else {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
    }

    public String updateCliente(Cliente cliente) throws ExecutionException, InterruptedException {
        validarCampos(cliente);
        Cliente existingCliente = clienteRepository.findById(cliente.getID());
        if (existingCliente == null) {
            return "Frete não encontrado para atualização.";
        } else {
            clienteRepository.update(cliente);
            return "O Frete foi atualizado com sucesso!";
        }
    }

    public String deletaCliente(String id) throws ExecutionException, InterruptedException {
        if (id != null) {
            Optional<Cliente> clienteOptional = Optional.ofNullable(clienteRepository.findById(id));
            if (clienteOptional.isPresent()) {
                clienteRepository.deleteById(id);
                return "Cliente deletado com sucesso";
            } else {
                throw new IllegalArgumentException("ID não pode ser nulo");
            }
        } else {
            throw new IllegalArgumentException("ID inválido: Cliente não encontrado");
        }
    }

    private void validarCampos(Cliente cliente) {
        if (cliente.getID() == null || cliente.getCPF() == null || cliente.getEnd() == null || cliente.getCEP() == null
                || cliente.getTip() == null || cliente.getValor() == null) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos.");
        }

        if (!isNumeric(cliente.getCPF()) || !isNumeric(cliente.getCEP()) || !isNumeric(cliente.getValor())) {
            throw new IllegalArgumentException("CPF, CEP e Valor devem conter apenas números.");
        }
    }

    private boolean isNumeric(String value) {
        return value != null && value.matches("\\d+");
    }
}

package com.salesunity.appsu.core.services;

import com.salesunity.appsu.core.entities.DTO.ClienteDTO;
import com.salesunity.appsu.core.entities.Cliente;
import com.salesunity.appsu.core.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<ClienteDTO> getAllClientes(){
        return clienteRepository.findAll().stream().map(ClienteDTO :: new).toList();
    }
    public ClienteDTO getClienteByEmail(String email){
        Cliente cliente = clienteRepository.findClienteByEmail(email).orElseThrow(() ->
                new NoSuchElementException("cliente não encontrado com o email: " +email));
        return new ClienteDTO(cliente);
    }
    public ClienteDTO createCliente(ClienteDTO clienteDTO){

        Cliente cliente = new Cliente();
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNome_cliente(clienteDTO.getNome_cliente());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setHistorico(clienteDTO.getHistorico());
        cliente.setCompras(clienteDTO.getCompras());

        clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }
    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public ClienteDTO updateCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findClienteByEmail(clienteDTO.getEmail()).orElseThrow(() ->
                new NoSuchElementException("Cliente não encontrado com email: " + clienteDTO.getEmail()));

        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNome_cliente(clienteDTO.getNome_cliente());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setHistorico(clienteDTO.getHistorico());
        cliente.setCompras(clienteDTO.getCompras());

        return new ClienteDTO(cliente);
    }
    
}

package com.salesunity.appsu.core.services;

import com.salesunity.appsu.core.entities.Cliente;
import com.salesunity.appsu.core.entities.DTO.CompraDTO;
import com.salesunity.appsu.core.entities.Compra;
import com.salesunity.appsu.core.repositories.ClienteRepository;
import com.salesunity.appsu.core.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<CompraDTO> getAllCompras(){
        return compraRepository.findAll().stream().map(CompraDTO :: new).toList();
    }
    public CompraDTO getById(Long id){
        Compra compra = compraRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("compra não encontrada com o email: " +id));
        return new CompraDTO(compra);
    }
    public CompraDTO createCompra(CompraDTO compraDTO){

        Cliente cliente = clienteRepository.findClienteByEmail(compraDTO.getEmail_cliente()).orElseThrow(() ->
                new NoSuchElementException("Cliente não foi encontrado com email: " + compraDTO.getEmail_cliente()));
        List<Compra> compras = cliente.getCompras();
        Compra compra = new Compra();
        compra.setId(compra.getId());
        compra.setQuantidade(compraDTO.getQuantidade());
        compra.setPreco_compra(compraDTO.getPreco_compra());
        compra.setTransportadora(compraDTO.getTransportadora());
        compra.setCliente(cliente);

        compras.add(compra);
        clienteRepository.save(cliente);

        compraRepository.save(compra);
        return new CompraDTO(compra);
    }
    public void deleteCompra(Long id){
        compraRepository.deleteById(id);
    }

    public CompraDTO updateCompra(CompraDTO compraDTO) {
        Compra compra = compraRepository.findById(compraDTO.getId()).orElseThrow(() ->
                new NoSuchElementException("Compra não encontrada com id: " + compraDTO.getId()));

        Cliente cliente = clienteRepository.findClienteByEmail(compraDTO.getEmail_cliente()).orElseThrow(() ->
                new NoSuchElementException("Cliente não foi encontrado com email: " + compraDTO.getEmail_cliente()));
        List<Compra> compras = cliente.getCompras();
        compra.setId(compra.getId());
        compra.setQuantidade(compraDTO.getQuantidade());
        compra.setPreco_compra(compraDTO.getPreco_compra());
        compra.setTransportadora(compraDTO.getTransportadora());
        compra.setCliente(cliente);

        compras.add(compra);
        clienteRepository.save(cliente);

        compraRepository.save(compra);
        return new CompraDTO(compra);
    }
    
}

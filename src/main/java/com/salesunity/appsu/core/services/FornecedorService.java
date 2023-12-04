package com.salesunity.appsu.core.services;

import com.salesunity.appsu.core.entities.Fornecedor;
import com.salesunity.appsu.core.entities.DTO.FornecedorDTO;
import com.salesunity.appsu.core.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Iterable<FornecedorDTO> getAllFornecedors(){
        return fornecedorRepository.findAll().stream().map(FornecedorDTO :: new).toList();
    }
    public FornecedorDTO getFornecedorById(Long id){
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("fornecedor não encontrado com o id: " +id));
        return new FornecedorDTO(fornecedor);
    }
    public FornecedorDTO createFornecedor(FornecedorDTO fornecedorDTO){

        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setId(fornecedorDTO.getId());
        fornecedor.setNome_empresa(fornecedorDTO.getNome_empresa());
        fornecedor.setEndereco(fornecedorDTO.getEndereco());
        fornecedor.setTelefone(fornecedorDTO.getTelefone());
        fornecedor.setCategoria_prd_fornecidos(fornecedorDTO.getCategoria_prd_fornecidos());
        fornecedor.setProdutos(fornecedorDTO.getProdutos());
        fornecedor.setTransportadoras(fornecedorDTO.getTransportadoras());
        fornecedorRepository.save(fornecedor);
        return new FornecedorDTO(fornecedor);
    }
    public void deleteFornecedor(Long id){
        fornecedorRepository.deleteById(id);
    }
    public FornecedorDTO updateFornecedor(FornecedorDTO fornecedorDTO){

        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorDTO.getId()).orElseThrow(() ->
                new NoSuchElementException("Fornecedor não encontrado com id: " + fornecedorDTO.getId()));

        fornecedor.setId(fornecedorDTO.getId());
        fornecedor.setNome_empresa(fornecedorDTO.getNome_empresa());
        fornecedor.setEndereco(fornecedorDTO.getEndereco());
        fornecedor.setTelefone(fornecedorDTO.getTelefone());
        fornecedor.setCategoria_prd_fornecidos(fornecedorDTO.getCategoria_prd_fornecidos());
        fornecedor.setProdutos(fornecedorDTO.getProdutos());
        fornecedor.setTransportadoras(fornecedorDTO.getTransportadoras());
        fornecedorRepository.save(fornecedor);
        return new FornecedorDTO(fornecedor);
    }
}

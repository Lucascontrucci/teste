package com.salesunity.appsu.core.services;

import com.salesunity.appsu.core.entities.Compra;
import com.salesunity.appsu.core.entities.DTO.TransportadoraDTO;
import com.salesunity.appsu.core.entities.Fornecedor;
import com.salesunity.appsu.core.entities.Transportadora;
import com.salesunity.appsu.core.repositories.CompraRepository;
import com.salesunity.appsu.core.repositories.FornecedorRepository;
import com.salesunity.appsu.core.repositories.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class TransportadoraService {

    @Autowired
    private TransportadoraRepository transportadoraRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private CompraRepository compraRepository;
    public Iterable<TransportadoraDTO> getAllTransportadoras(){
        return transportadoraRepository.findAll().stream().map(TransportadoraDTO :: new).toList();
    }
    public TransportadoraDTO getTransportadoraById(Long id){
        Transportadora transportadora = transportadoraRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Transportadora não encontrado com o id: " +id));
        return new TransportadoraDTO(transportadora);
    }
    public TransportadoraDTO createTransportadora(TransportadoraDTO transportadoraDTO){

        Transportadora transportadora = new Transportadora();

        List<Fornecedor> fornecedorList = transportadora.getFornecedores();
        List<Compra> compraList = transportadora.getCompras();

        transportadora.setId(transportadora.getId());
        transportadora.setNome_transportadora(transportadora.getNome_transportadora());
        transportadora.setEmail(transportadora.getEmail());
        transportadora.setEndereco(transportadora.getEndereco());
        transportadora.setTelefone(transportadora.getTelefone());
        transportadora.setTipos_servico(transportadoraDTO.getTipos_servico());

        for(Long fornecedor : transportadoraDTO.getFornecedores_id()){
            Fornecedor fornecedorObject = fornecedorRepository.findById(fornecedor).orElseThrow(() ->
                    new NoSuchElementException("Um dos fornecedores não foi encontrado com id: " + fornecedor));
            fornecedorList.add(fornecedorObject);
            List<Transportadora> transportadoraList = fornecedorObject.getTransportadoras();
            transportadoraList.add(transportadora);
            fornecedorObject.setTransportadoras(transportadoraList);
            fornecedorRepository.save(fornecedorObject);
        }
        transportadora.setFornecedores(fornecedorList);
        for(Long compra : transportadoraDTO.getFornecedores_id()){
            Compra compraObject = compraRepository.findById(compra).orElseThrow(() ->
                    new NoSuchElementException("Uma das compras não foi encontrado com id: " + compra));
            compraList.add(compraObject);
            compraObject.setTransportadora(transportadora);
            compraRepository.save(compraObject);
        }
        transportadora.setCompras(compraList);

        transportadoraRepository.save(transportadora);
        return new TransportadoraDTO(transportadora);
    }
    public void deleteTransportadora(Long id){
        transportadoraRepository.deleteById(id);
    }
    public TransportadoraDTO updateTransportadora(TransportadoraDTO transportadoraDTO){

        Transportadora transportadora = transportadoraRepository.findById(transportadoraDTO.getId()).orElseThrow(() ->
                new NoSuchElementException("Transportadora não encontrada com id: " + transportadoraDTO.getId()));

        List<Fornecedor> fornecedorList = transportadora.getFornecedores();
        List<Compra> compraList = transportadora.getCompras();


        transportadora.setId(transportadora.getId());
        transportadora.setNome_transportadora(transportadora.getNome_transportadora());
        transportadora.setEmail(transportadora.getEmail());
        transportadora.setEndereco(transportadora.getEndereco());
        transportadora.setTelefone(transportadora.getTelefone());
        transportadora.setTipos_servico(transportadoraDTO.getTipos_servico());

        for(Long fornecedor : transportadoraDTO.getFornecedores_id()){
            Fornecedor fornecedorObject = fornecedorRepository.findById(fornecedor).orElseThrow(() ->
                    new NoSuchElementException("Um dos fornecedores não foi encontrado com id: " + fornecedor));
            fornecedorList.add(fornecedorObject);
            List<Transportadora> transportadoraList = fornecedorObject.getTransportadoras();
            transportadoraList.add(transportadora);
            fornecedorObject.setTransportadoras(transportadoraList);
            fornecedorRepository.save(fornecedorObject);
        }
        transportadora.setFornecedores(fornecedorList);
        for(Long compra : transportadoraDTO.getFornecedores_id()){
            Compra compraObject = compraRepository.findById(compra).orElseThrow(() ->
                    new NoSuchElementException("Uma das compras não foi encontrado com id: " + compra));
            compraList.add(compraObject);
            compraObject.setTransportadora(transportadora);
            compraRepository.save(compraObject);
        }
        transportadora.setCompras(compraList);

        transportadoraRepository.save(transportadora);
        return new TransportadoraDTO(transportadora);
    }
    
}

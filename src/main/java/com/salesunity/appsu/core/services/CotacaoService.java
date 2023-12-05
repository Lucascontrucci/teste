package com.salesunity.appsu.core.services;

import com.salesunity.appsu.core.entities.Cotacao;
import com.salesunity.appsu.core.entities.DTO.CotacaoDTO;
import com.salesunity.appsu.core.entities.Usuario;
import com.salesunity.appsu.core.repositories.CotacaoRepository;
import com.salesunity.appsu.core.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CotacaoService {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Iterable<CotacaoDTO> getAllCotacaos(){
        return cotacaoRepository.findAll().stream().map(CotacaoDTO :: new).toList();
    }
    public CotacaoDTO getCotacaoById(Long id){
        Cotacao cotacao = cotacaoRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("cotacao não encontrada com o id: " +id));
        return new CotacaoDTO(cotacao);
    }
    public CotacaoDTO createCotacao(CotacaoDTO cotacaoDTO){

        Cotacao cotacao = new Cotacao();
        Usuario usuario = usuarioRepository.findUsuarioByEmail(cotacaoDTO.getUsuario_email()).orElseThrow(() ->
                new NoSuchElementException("Usuario não encontrado com email: " + cotacaoDTO.getUsuario_email()));

        List<Cotacao> cotacoes = usuario.getCotacoes();

        cotacao.setId(cotacaoDTO.getId());
        cotacao.setStatus_cotacao(cotacaoDTO.getStatus_cotacao());
        cotacao.setData_cotacao(cotacaoDTO.getData_cotacao());
        cotacao.setProduto_cotacao(cotacaoDTO.getProduto_cotacao());
        cotacao.setFornecedor(cotacaoDTO.getFornecedor());
        cotacao.setUsuario(usuario);
        cotacoes.add(cotacao);
        usuario.setCotacoes(cotacoes);
        cotacaoRepository.save(cotacao);
        usuarioRepository.save(usuario);
        return new CotacaoDTO(cotacao);
    }
    public void deleteCotacao(Long id){
        cotacaoRepository.deleteById(id);
    }
    public CotacaoDTO updateCotacao(CotacaoDTO cotacaoDTO){

        Cotacao cotacao = cotacaoRepository.findById(cotacaoDTO.getId()).orElseThrow(() ->
                new NoSuchElementException("Cotacao não encontrado com id: " + cotacaoDTO.getId()));

        Usuario usuario = usuarioRepository.findUsuarioByEmail(cotacaoDTO.getUsuario_email()).orElseThrow(() ->
                new NoSuchElementException("Usuario não encontrado com email: " + cotacaoDTO.getUsuario_email()));

        List<Cotacao> cotacoes = usuario.getCotacoes();

        cotacao.setId(cotacaoDTO.getId());
        cotacao.setStatus_cotacao(cotacaoDTO.getStatus_cotacao());
        cotacao.setData_cotacao(cotacaoDTO.getData_cotacao());
        cotacao.setProduto_cotacao(cotacaoDTO.getProduto_cotacao());
        cotacao.setFornecedor(cotacaoDTO.getFornecedor());
        cotacao.setUsuario(usuario);
        cotacoes.add(cotacao);
        usuario.setCotacoes(cotacoes);
        cotacaoRepository.save(cotacao);
        usuarioRepository.save(usuario);
        return new CotacaoDTO(cotacao);
    }
}

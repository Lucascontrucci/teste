package com.salesunity.appsu.core.services;

import com.salesunity.appsu.core.entities.Cotacao;
import com.salesunity.appsu.core.entities.ItemCotacao;
import com.salesunity.appsu.core.entities.DTO.ItemCotacaoDTO;
import com.salesunity.appsu.core.entities.Produto;
import com.salesunity.appsu.core.entities.Usuario;
import com.salesunity.appsu.core.repositories.CotacaoRepository;
import com.salesunity.appsu.core.repositories.ItemCotacaoRepository;
import com.salesunity.appsu.core.repositories.ProdutoRepository;
import com.salesunity.appsu.core.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ItemCotacaoService {

    @Autowired
    private ItemCotacaoRepository itemCotacaoRepository;
    @Autowired
    private CotacaoRepository cotacaoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Iterable<ItemCotacaoDTO> getAllItemCotacaos(){
        return itemCotacaoRepository.findAll().stream().map(ItemCotacaoDTO :: new).toList();
    }
    public ItemCotacaoDTO getItemCotacaoById(UUID id){
        ItemCotacao itemCotacao = itemCotacaoRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("itemCotacao não encontrada com o id: " +id));
        return new ItemCotacaoDTO(itemCotacao);
    }
    public ItemCotacaoDTO createItemCotacao(ItemCotacaoDTO itemCotacaoDTO){

        ItemCotacao itemCotacao = new ItemCotacao();

        Produto produto = produtoRepository.findById(itemCotacaoDTO.getProduto_id()).orElseThrow(() ->
                new NoSuchElementException("Produto não encontrado com id: " + itemCotacaoDTO.getProduto_id()));

        Cotacao cotacao = cotacaoRepository.findById(itemCotacaoDTO.getCotacao_id()).orElseThrow(() ->
                new NoSuchElementException("Cotação não encontrada com id: " + itemCotacaoDTO.getProduto_id()));


        List<ItemCotacao> itemCotacoes = cotacao.getProduto_cotacao();

        itemCotacao.setId(itemCotacao.getId());
        itemCotacao.setQtd_solicitada(itemCotacao.getQtd_solicitada());
        itemCotacao.setPrc_cotado(itemCotacao.getPrc_cotado());
        itemCotacao.setProduto(produto);
        itemCotacao.setCotacao(cotacao);

        itemCotacoes.add(itemCotacao);
        cotacao.setProduto_cotacao(itemCotacoes);
        produto.setProduto_cotacao(itemCotacoes);

        cotacaoRepository.save(cotacao);
        produtoRepository.save(produto);
        itemCotacaoRepository.save(itemCotacao);

        return new ItemCotacaoDTO(itemCotacao);
    }
    public void deleteItemCotacao(UUID id){
        itemCotacaoRepository.deleteById(id);
    }
    public ItemCotacaoDTO updateItemCotacao(ItemCotacaoDTO itemCotacaoDTO){

        ItemCotacao itemCotacao = itemCotacaoRepository.findById(itemCotacaoDTO.getId()).orElseThrow(() ->
                new NoSuchElementException("ItemCotacao não encontrado com id: " + itemCotacaoDTO.getId()));

        Produto produto = produtoRepository.findById(itemCotacaoDTO.getProduto_id()).orElseThrow(() ->
                new NoSuchElementException("Produto não encontrado com id: " + itemCotacaoDTO.getProduto_id()));

        Cotacao cotacao = cotacaoRepository.findById(itemCotacaoDTO.getCotacao_id()).orElseThrow(() ->
                new NoSuchElementException("Cotação não encontrada com id: " + itemCotacaoDTO.getProduto_id()));


        List<ItemCotacao> itemCotacoes = cotacao.getProduto_cotacao();

        itemCotacao.setId(itemCotacao.getId());
        itemCotacao.setQtd_solicitada(itemCotacao.getQtd_solicitada());
        itemCotacao.setPrc_cotado(itemCotacao.getPrc_cotado());
        itemCotacao.setProduto(produto);
        itemCotacao.setCotacao(cotacao);

        itemCotacoes.add(itemCotacao);
        cotacao.setProduto_cotacao(itemCotacoes);
        produto.setProduto_cotacao(itemCotacoes);

        cotacaoRepository.save(cotacao);
        produtoRepository.save(produto);
        itemCotacaoRepository.save(itemCotacao);

        return new ItemCotacaoDTO(itemCotacao);
    }

}

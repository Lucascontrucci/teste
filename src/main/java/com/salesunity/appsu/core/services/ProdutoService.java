package com.salesunity.appsu.core.services;

import com.salesunity.appsu.core.entities.*;
import com.salesunity.appsu.core.entities.DTO.CotacaoDTO;
import com.salesunity.appsu.core.entities.DTO.ProdutoDTO;
import com.salesunity.appsu.core.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ItemCotacaoRepository itemCotacaoRepository;
    public Iterable<ProdutoDTO> getAllProdutos(){
        return produtoRepository.findAll().stream().map(ProdutoDTO :: new).toList();
    }
    public ProdutoDTO getProdutoById(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Produto não encontrado com o id: " +id));
        return new ProdutoDTO(produto);
    }
    public ProdutoDTO createProduto(ProdutoDTO produtoDTO){

        Produto produto = new Produto();

        List<Fornecedor> fornecedorList = produto.getFornecedores();
        List<ItemCotacao> itemList = produto.getProduto_cotacao();


        produto.setId(produtoDTO.getId());
        produto.setNome_produto(produtoDTO.getNome_produto());
        produto.setPrc_unitario(produtoDTO.getPrc_unitario());
        produto.setDescricao_produto(produtoDTO.getDescricao_produto());
        produto.setUnidade_medida(produtoDTO.getUnidade_medida());

        for(Long fornecedor : produtoDTO.getFornecedores_id()){
            Fornecedor fornecedorObject = fornecedorRepository.findById(fornecedor).orElseThrow(() ->
                    new NoSuchElementException("Um dos fornecedores não foi encontrado com id: " + fornecedor));
            fornecedorList.add(fornecedorObject);
            List<Produto> produtoList = fornecedorObject.getProdutos();
            produtoList.add(produto);
            fornecedorObject.setProdutos(produtoList);
            fornecedorRepository.save(fornecedorObject);
        }
        produto.setFornecedores(fornecedorList);
        for(UUID item : produtoDTO.getItem_cotacoes_id()){
            ItemCotacao itemObject = itemCotacaoRepository.findById(item).orElseThrow(() ->
                    new NoSuchElementException("Uma das cotações não foi encontrada com id: " + item));
            itemList.add(itemObject);
            itemObject.setProduto(produto);
            itemCotacaoRepository.save(itemObject);
        }
        produto.setProduto_cotacao(itemList);

        produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }
    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }
    public ProdutoDTO updateProduto(ProdutoDTO produtoDTO){

        Produto produto = produtoRepository.findById(produtoDTO.getId()).orElseThrow(() ->
                new NoSuchElementException("Produto não encontrada com id: " + produtoDTO.getId()));

        List<Fornecedor> fornecedorList = produto.getFornecedores();
        List<ItemCotacao> itemList = produto.getProduto_cotacao();


        produto.setId(produtoDTO.getId());
        produto.setNome_produto(produtoDTO.getNome_produto());
        produto.setPrc_unitario(produtoDTO.getPrc_unitario());
        produto.setDescricao_produto(produtoDTO.getDescricao_produto());
        produto.setUnidade_medida(produtoDTO.getUnidade_medida());

        for(Long fornecedor : produtoDTO.getFornecedores_id()){
            Fornecedor fornecedorObject = fornecedorRepository.findById(fornecedor).orElseThrow(() ->
                    new NoSuchElementException("Um dos fornecedores não foi encontrado com id: " + fornecedor));
            fornecedorList.add(fornecedorObject);
            List<Produto> produtoList = fornecedorObject.getProdutos();
            produtoList.add(produto);
            fornecedorObject.setProdutos(produtoList);
            fornecedorRepository.save(fornecedorObject);
        }
        produto.setFornecedores(fornecedorList);
        for(UUID item : produtoDTO.getItem_cotacoes_id()){
            ItemCotacao itemObject = itemCotacaoRepository.findById(item).orElseThrow(() ->
                    new NoSuchElementException("Uma das cotações não foi encontrada com id: " + item));
            itemList.add(itemObject);
            itemObject.setProduto(produto);
            itemCotacaoRepository.save(itemObject);
        }
        produto.setProduto_cotacao(itemList);

        produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }


}

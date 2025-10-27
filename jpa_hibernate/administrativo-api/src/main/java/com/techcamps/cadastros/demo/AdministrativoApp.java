package com.techcamps.cadastros.demo;

import com.techcamps.cadastros.entities.Pessoa;
import com.techcamps.cadastros.entities.Produto;
import com.techcamps.cadastros.models.PessoaModel;
import com.techcamps.cadastros.models.ProdutoModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(new BigDecimal("300.00"));
        p1.setQuantidade(100);
        p1.setStatus("ATIVO");

        produtoModel.create(p1);

        Produto p2 = new Produto();
        p2.setNome("Notebook");
        p2.setPreco(new BigDecimal("4500.00"));
        p2.setQuantidade(20);
        p2.setStatus("ATIVO");
        produtoModel.create(p2);


        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados: " + produtos.size());
        Produto buscado = produtoModel.findById(p1);
        System.out.println("Produto buscado por ID: " + (buscado != null ? buscado.getNome() : "null"));


        p1.setPreco(new BigDecimal("279.90"));
        p1.setQuantidade(95);
        p1.setStatus("ATIVO");
        produtoModel.update(p1);

        produtoModel.delete(p2);

        Pessoa pes1 = new Pessoa();
        pes1.setNome("Maria Souza");
        pes1.setEmail("maria@example.com");
        pes1.setIdade(28);
        pes1.setCpf("12345678901");
        pes1.setDataNascimento(LocalDate.of(1997, 5, 12));

        pessoaModel.create(pes1);

        Pessoa pes2 = new Pessoa();
        pes2.setNome("João Lima");
        pes2.setEmail("joao@example.com");
        pes2.setIdade(33);
        pes2.setCpf("98765432100");
        pes2.setDataNascimento(LocalDate.of(1992, 10, 3));

        pessoaModel.create(pes2);

        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas: " + pessoas.size());

        Pessoa pessoaBuscada = pessoaModel.findById(pes1);
        System.out.println("Pessoa buscada por ID: " + (pessoaBuscada != null ? pessoaBuscada.getNome() : "null"));

        pes1.setEmail("maria.souza@empresa.com");
        pes1.setIdade(29);
        pessoaModel.update(pes1);

        pessoaModel.delete(pes2);

        System.out.println("Produtos (final): " + produtoModel.findAll().size());
        System.out.println("Pessoas (final): " + pessoaModel.findAll().size());

        System.out.println("CRUD de Produto e Pessoa executado com sucesso.");
    }
}


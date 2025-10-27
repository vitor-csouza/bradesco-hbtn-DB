package com.techcamps.cadastros.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false, length = 20)
    private String status; // ex.: "ATIVO", "INATIVO"

    // Construtores
    public Produto() {}

    public Produto(String nome, Integer quantidade, BigDecimal preco, String status) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.status = status;
    }

    // Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}


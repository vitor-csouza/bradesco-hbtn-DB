package com.techcamps.cadastros.models;

import com.techcamps.cadastros.entities.Produto;

import javax.persistence.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Erro ao criar o produto !!! " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação (update)");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Erro ao atualizar o produto !!! " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação (update)");
        }
    }

    public void delete(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação (delete)");
            em.getTransaction().begin();
            Produto gerenciado = em.find(Produto.class, p.getId());
            if (gerenciado != null) {
                em.remove(gerenciado);
                System.out.println("Produto removido com sucesso !!!");
            } else {
                System.out.println("Produto não encontrado para remoção.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Erro ao remover o produto !!! " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação (delete)");
        }
    }

    public Produto findById(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Produto.class, p.getId());
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Produto> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            List<Produto> produtos = new ArrayList<>();
            TypedQuery<Produto> q = em.createQuery("SELECT p FROM Produto p", Produto.class);
            produtos = q.getResultList();
            return produtos;
        } finally {
            em.close();
            emf.close();
        }
    }
}

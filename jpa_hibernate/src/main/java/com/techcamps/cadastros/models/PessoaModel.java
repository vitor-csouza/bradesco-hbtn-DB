package com.techcamps.cadastros.models;

import com.techcamps.cadastros.entities.Pessoa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Erro ao criar a pessoa !!! " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação (update)");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso !!!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Erro ao atualizar a pessoa !!! " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação (update)");
        }
    }

    public void delete(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação (delete)");
            em.getTransaction().begin();
            Pessoa gerenciada = em.find(Pessoa.class, p.getId());
            if (gerenciada != null) {
                em.remove(gerenciada);
                System.out.println("Pessoa removida com sucesso !!!");
            } else {
                System.out.println("Pessoa não encontrada para remoção.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Erro ao remover a pessoa !!! " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação (delete)");
        }
    }

    public Pessoa findById(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Pessoa.class, p.getId());
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Pessoa> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            List<Pessoa> pessoas = new ArrayList<>();
            TypedQuery<Pessoa> q = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
            pessoas = q.getResultList();
            return pessoas;
        } finally {
            em.close();
            emf.close();
        }
    }
}


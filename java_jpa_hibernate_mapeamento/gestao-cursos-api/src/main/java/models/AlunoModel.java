package models;


import entities.Aluno;


import javax.persistence.*;
import java.util.List;


public class AlunoModel {


    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Erro ao criar um aluno !!! " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }


    public Aluno findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Aluno.class, id);
        } finally {
            em.close();
            emf.close();
        }
    }


    public List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }


    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso !!!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Erro ao atualizar o aluno !!! " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }


    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Aluno managed = em.find(Aluno.class, aluno.getId());
            if (managed != null) em.remove(managed);
            em.getTransaction().commit();
            System.out.println("Aluno removido com sucesso !!!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Erro ao remover o aluno !!! " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
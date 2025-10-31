package entities;


import javax.persistence.*;
import java.util.*;


@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;


    @OneToMany(mappedBy = "professor")
    private List<Curso> cursos = new ArrayList<>();


    public Professor() {}
    public Professor(String nome) { this.nome = nome; }


    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Curso> getCursos() { return cursos; }
}
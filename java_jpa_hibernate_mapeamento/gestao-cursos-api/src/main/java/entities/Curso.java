package entities;


import javax.persistence.*;
import java.util.*;


@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;

    @ManyToOne(optional = false)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "material_id", unique = true)
    private MaterialCurso material;

    @ManyToMany(mappedBy = "cursos")
    private Set<Aluno> alunos = new HashSet<>();

    public Curso() {

    }

    public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }


    public MaterialCurso getMaterial() { return material; }
    public void setMaterial(MaterialCurso material) { this.material = material; material.setCurso(this); }


    public Set<Aluno> getAlunos() { return alunos; }
}
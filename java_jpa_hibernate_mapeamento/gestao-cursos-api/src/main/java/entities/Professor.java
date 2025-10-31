package entities;


import javax.persistence.*;
import java.util.*;


@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String matricula;
    private String email;

    @OneToMany(mappedBy = "professor")
    private List<Curso> cursos = new ArrayList<>();


    public Professor() {

    }
    public Professor(String nomeCompleto, String matricula, String email) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nomeCompleto;
    }

    public void setNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.matricula = matricula;
    }

    public List<Curso> getCursos() {
        return cursos;
    }
}
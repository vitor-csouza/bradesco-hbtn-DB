package entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate nascimento;


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "curso_aluno",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Set<Curso> cursos = new HashSet<>();


    public Aluno() {}
    public Aluno(String nome) { this.nome = nome; }


    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getNascimento() { return nascimento; }
    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; }


    public List<Endereco> getEnderecos() { return enderecos; }
    public List<Telefone> getTelefones() { return telefones; }
    public Set<Curso> getCursos() { return cursos; }


    public void addEndereco(Endereco e){ e.setAluno(this); enderecos.add(e);}
    public void addTelefone(Telefone t){ t.setAluno(this); telefones.add(t);}
    public void addCurso(Curso c){ cursos.add(c); c.getAlunos().add(this);}
}
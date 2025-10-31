package entities;


import javax.persistence.*;


@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String numero;
    private String ddd;


    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    public Telefone() {}
    public Telefone(String numero, String ddd) { this.numero = numero; this.ddd = ddd; }


    public Long getId() { return id; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
}
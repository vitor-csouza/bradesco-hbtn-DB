package entities;


import javax.persistence.*;


@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String numero;
    private String tipo; // ex.: "celular", "fixo"


    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    public Telefone() {}
    public Telefone(String numero, String tipo) { this.numero = numero; this.tipo = tipo; }


    public Long getId() { return id; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
}
package entities;


import javax.persistence.*;


@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String logradouro;
    private String numero;
    private String bairro;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;


    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    public Endereco() {}
    public Endereco(String logradouro, String numero, String cidade, String estado, String cep, String bairro, String endereco) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.bairro = bairro;
        this.endereco = endereco;
    }


    public Long getId() { return id; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.cep = bairro; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.cep = endereco; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
}
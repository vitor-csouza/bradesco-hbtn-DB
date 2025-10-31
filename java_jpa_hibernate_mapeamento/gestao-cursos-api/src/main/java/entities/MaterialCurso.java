package entities;


import javax.persistence.*;


@Entity
public class MaterialCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;


    @OneToOne(mappedBy = "material")
    private Curso curso;


    public MaterialCurso() {}
    public MaterialCurso(String url) { this.url = url; }


    public Long getId() { return id; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}
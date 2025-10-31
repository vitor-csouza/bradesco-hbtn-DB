package demo;


import entities.*;
import models.AlunoModel;
import models.CursoModel;


public class GestaoCursosMain {
    public static void main(String[] args) {
// Criar 1 aluno (com um telefone e um endereço)
        Aluno aluno = new Aluno("Maria da Silva");
        aluno.addEndereco(new Endereco("Rua das Flores", "100", "São Paulo", "SP", "01000-000"));
        aluno.addTelefone(new Telefone("11-99999-0000", "celular"));


// Criar 1 professor
        Professor prof = new Professor("Prof. João");


// Criar 1 material de curso
        MaterialCurso material = new MaterialCurso("https://meu-curso.com/materials/java-basico.pdf");


// Criar 1 curso (com um professor e um aluno) e um material do curso
        Curso curso = new Curso("Java Básico");
        curso.setProfessor(prof);
        curso.setMaterial(material);


// Relacionar aluno ao curso (ManyToMany)
        aluno.addCurso(curso);


// Persistir via Models
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();


// Persistindo: ao persistir o Curso, o Professor e MaterialCurso são persistidos (cascade do material está ON; professor é ManyToOne e será persistido se já estiver gerenciado;
// para garantir, persistimos via cascata apenas o material e salvamos o professor "transiente" junto ao curso por persist do curso)
// Uma estratégia simples é persistir primeiro o professor, depois o curso, depois o aluno.


// Persist professor isolado
// Para facilitar sem criar ProfessorModel, aproveitamos o cascade do curso: setProfessor(prof) + persist(curso)


// 1) Criar curso (com professor e material)
        cursoModel.create(curso);


// 2) Criar aluno (com endereço/telefone e relação com curso)
        alunoModel.create(aluno);


// Testes básicos CRUD
        System.out.println("Total de cursos: " + cursoModel.findAll().size());
        System.out.println("Total de alunos: " + alunoModel.findAll().size());


// Update
        curso.setNome("Java Básico - Atualizado");
        cursoModel.update(curso);


// Delete (exemplo — comente se não quiser apagar)
// alunoModel.delete(aluno);
// cursoModel.delete(curso);


        System.out.println("Seed concluído.");
    }
}
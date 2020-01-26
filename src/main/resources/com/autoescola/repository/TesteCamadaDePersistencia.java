
package com.autoescola.repository;

import com.autoescola.model.Aluno;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteCamadaDePersistencia {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoescola");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        //Instanciar os repositorios
        Alunos alunos = new Alunos(em);
        
        //Listar os alunos
        List<Aluno> listaAlunos = alunos.pesquisar("");
        System.out.println(listaAlunos);
        
        //Criar um Aluno
        Aluno a = new Aluno();
        a.setNome("Pedro");
        a.setRG("tea");
        a.setCPF("1111");
        a.setTelefone("1111");
        a.setEmail("1111");
        a.setDataNascimento(new Date (1990-02-01));
        a.setEndereco("Benjamim");
        
        //Salvar Alunos
        alunos.salvar(a);
        
        em.getTransaction().commit();
        
        List<Aluno> lista = em.createQuery("from Aluno",Aluno.class).getResultList();
        System.out.println(lista);
        
        em.close();
        emf.close();
    }
   
    
    
}

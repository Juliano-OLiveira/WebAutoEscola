
package com.autoescola.bean;

import com.autoescola.model.Aluno;
import com.autoescola.repository.Alunos;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AlunosBean {
     
    @Inject
    private Alunos alunos ;
    
    private List<Aluno> listaDeAlunos;
    
    public void todosOsAlunos(){
    listaDeAlunos = alunos.pesquisarTodos();
    
    
    }
    
    public List<Aluno> getListaDeAlunos(){
    return listaDeAlunos;
        
    }
}

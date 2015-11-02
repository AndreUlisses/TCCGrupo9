/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import dao.ProjetoDao;
import entidade.Projeto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NoteH
 */
public class Main {
 
    public static void main(String[] args) {
         
        List<Projeto> lista = new ArrayList();
        ProjetoDao projetoDao = new ProjetoDao();
        
        lista = projetoDao.listar();
        
        for (Projeto umProjeto : lista) {
            System.out.println(umProjeto.getTitulo());
        }
}
}
    
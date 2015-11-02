/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexao.ConnectionManager;
import entidade.Projeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NoteH
 */
public class ProjetoDao {
    
    
    public int salvar(Projeto projeto) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into Projeto (Titulo, Subtitulo, Autores, Curso) values (?, ?, ?, ?)";
            String QUERY_UPDATE = "update USUARIO set Titulo = ?, Subtitulo = ?, Autores = ?, Curso = ? where idprojeto = ? ";

            if (projeto.getId()== null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, projeto.getTitulo());
                stmt.setString(2, projeto.getSubtitulo());
                stmt.setString(3, projeto.getAutores());
                stmt.setString(4, projeto.getCurso());
                /*stmt.setString(4, projeto.getDT_Publicacao());*/

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, projeto.getTitulo());
                stmt.setString(2, projeto.getSubtitulo());
                stmt.setString(3, projeto.getAutores());
                stmt.setString(4, projeto.getCurso());
                stmt.setInt(3, projeto.getAno());
                stmt.setInt(3, projeto.getSemestre());
                stmt.setString(4, projeto.getCurso());
                
                stmt.setInt(5, projeto.getId());

                stmt.executeUpdate();
                resultado = projeto.getId(); // alterei aqui pra ficar igual ao do ProfessorDAO
            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            
        }

        return resultado;
    }

    public boolean excluir(Projeto projeto) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from PROJETO where idprojeto = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, projeto.getId());

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public Projeto editar(int id) {

        Projeto usuario = new Projeto();
        
        try {

            String QUERY_DETALHE = "select * from PROJETO where idusuario = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setId(rs.getInt("idprojeto"));
                projeto.setTitulo(rs.getString("titulo"));
                projeto.setSubtitulo(rs.getString("subtitulo"));
                projeto.setAutores(rs.getString("autores"));
                projeto.setCurso(rs.getString("curso"));
                projeto.setAno(rs.getInt("ano"));
                projeto.setSemestre(rs.getInt("semestre"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            usuario = null;
            
        }
        
        return usuario;
    }

    public List<Projeto> listar() {
        List<Projeto> lista = new ArrayList<Projeto>();
        try {
            String QUERY_DETALHE = "select * from PROJETO";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();
 
            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setId(rs.getInt("idProjeto"));
                projeto.setTitulo(rs.getString("titulo"));
                projeto.setSubtitulo(rs.getString("subtitulo"));
                projeto.setAutores(rs.getString("autores"));
                projeto.setCurso(rs.getString("curso"));
                projeto.setAno(rs.getInt("ano"));
                projeto.setSemestre(rs.getInt("semestre"));
                
                lista.add(projeto);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            return lista;
            
        }
    }

}

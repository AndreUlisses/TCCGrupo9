/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.util.Date;

/**
 *
 * @author NoteH
 */
public class Projeto {
    
    private String Titulo;
    private String Subtitulo;
    private Date DT_Publicacao;
    private String Curso;
    private String Autores;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getSubtitulo() {
        return Subtitulo;
    }

    public void setSubtitulo(String Subtitulo) {
        this.Subtitulo = Subtitulo;
    }

    public Date getDT_Publicacao() {
        return DT_Publicacao;
    }

    public void setDT_Publicacao(Date DT_Publicacao) {
        this.DT_Publicacao = DT_Publicacao;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public String getAutores() {
        return Autores;
    }

    public void setAutores(String Autores) {
        this.Autores = Autores;
    }
    
}

package com.example.experimental.Modelos;

import java.util.List;

public class MPrerequisitos {

    private int idPrerequisitoCurso;
    private Boolean estadoPrerequisitoCurso;
    private String nombrePrerequisitoCurso;


    private List<MCursos> listcursos;

    public MPrerequisitos() {
    }

    public MPrerequisitos(int idPrerequisitoCurso, Boolean estadoPrerequisitoCurso, String nombrePrerequisitoCurso, List<MCursos> listcursos) {
        this.idPrerequisitoCurso = idPrerequisitoCurso;
        this.estadoPrerequisitoCurso = estadoPrerequisitoCurso;
        this.nombrePrerequisitoCurso = nombrePrerequisitoCurso;
        this.listcursos = listcursos;
    }

    public int getIdPrerequisitoCurso() {
        return idPrerequisitoCurso;
    }

    public void setIdPrerequisitoCurso(int idPrerequisitoCurso) {
        this.idPrerequisitoCurso = idPrerequisitoCurso;
    }

    public Boolean getEstadoPrerequisitoCurso() {
        return estadoPrerequisitoCurso;
    }

    public void setEstadoPrerequisitoCurso(Boolean estadoPrerequisitoCurso) {
        this.estadoPrerequisitoCurso = estadoPrerequisitoCurso;
    }

    public String getNombrePrerequisitoCurso() {
        return nombrePrerequisitoCurso;
    }

    public void setNombrePrerequisitoCurso(String nombrePrerequisitoCurso) {
        this.nombrePrerequisitoCurso = nombrePrerequisitoCurso;
    }

    public List<MCursos> getListcursos() {
        return listcursos;
    }

    public void setListcursos(List<MCursos> listcursos) {
        this.listcursos = listcursos;
    }
}
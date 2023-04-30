package com.example.experimental.Modelos;

import java.io.Serializable;
import java.util.List;

public class MUsuario implements Serializable {

    private int idUsuario;
    private String username;
    private String password;
    private String fotoPerfil;
    private Boolean estadoUsuarioActivo;
    private Boolean estadoActivoCapacitador;
    private String tituloCapacitador;

    private List<MCursos> listcursos;
    private List<MInscritos> listinscritos;

    public MUsuario() {
    }

    public MUsuario(int idUsuario, String username, String password, String fotoPerfil, Boolean estadoUsuarioActivo, Boolean estadoActivoCapacitador, String tituloCapacitador, List<MCursos> listcursos, List<MInscritos> listinscritos) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.fotoPerfil = fotoPerfil;
        this.estadoUsuarioActivo = estadoUsuarioActivo;
        this.estadoActivoCapacitador = estadoActivoCapacitador;
        this.tituloCapacitador = tituloCapacitador;
        this.listcursos = listcursos;
        this.listinscritos = listinscritos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Boolean getEstadoUsuarioActivo() {
        return estadoUsuarioActivo;
    }

    public void setEstadoUsuarioActivo(Boolean estadoUsuarioActivo) {
        this.estadoUsuarioActivo = estadoUsuarioActivo;
    }

    public Boolean getEstadoActivoCapacitador() {
        return estadoActivoCapacitador;
    }

    public void setEstadoActivoCapacitador(Boolean estadoActivoCapacitador) {
        this.estadoActivoCapacitador = estadoActivoCapacitador;
    }

    public String getTituloCapacitador() {
        return tituloCapacitador;
    }

    public void setTituloCapacitador(String tituloCapacitador) {
        this.tituloCapacitador = tituloCapacitador;
    }

    public List<MCursos> getListcursos() {
        return listcursos;
    }

    public void setListcursos(List<MCursos> listcursos) {
        this.listcursos = listcursos;
    }

    public List<MInscritos> getListinscritos() {
        return listinscritos;
    }

    public void setListinscritos(List<MInscritos> listinscritos) {
        this.listinscritos = listinscritos;
    }
}
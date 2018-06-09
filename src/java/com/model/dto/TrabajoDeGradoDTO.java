/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dto;

/**
 *
 * @author DidierPC
 */
public class TrabajoDeGradoDTO {
    
    private int n_proyecto,id_programa,resultado_propuesta,resultado_trabajofinal,año_sustentacion,periodo,cod_estudiante;
    private String nombre_proyecto,nombre_estudiante, modalidad,director,codirector,jurado1,jurado2;

    public int getN_proyecto() {
        return n_proyecto;
    }

    public void setN_proyecto(int n_proyecto) {
        this.n_proyecto = n_proyecto;
    }

    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public int getResultado_propuesta() {
        return resultado_propuesta;
    }

    public void setResultado_propuesta(int resultado_propuesta) {
        this.resultado_propuesta = resultado_propuesta;
    }

    public int getResultado_trabajofinal() {
        return resultado_trabajofinal;
    }

    public void setResultado_trabajofinal(int resultado_trabajofinal) {
        this.resultado_trabajofinal = resultado_trabajofinal;
    }

    public int getAño_sustentacion() {
        return año_sustentacion;
    }

    public void setAño_sustentacion(int año_sustentacion) {
        this.año_sustentacion = año_sustentacion;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getCod_estudiante() {
        return cod_estudiante;
    }

    public void setCod_estudiante(int cod_estudiante) {
        this.cod_estudiante = cod_estudiante;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCodirector() {
        return codirector;
    }

    public void setCodirector(String codirector) {
        this.codirector = codirector;
    }

    public String getJurado1() {
        return jurado1;
    }

    public void setJurado1(String jurado1) {
        this.jurado1 = jurado1;
    }

    public String getJurado2() {
        return jurado2;
    }

    public void setJurado2(String jurado2) {
        this.jurado2 = jurado2;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Carreras;

import Controlador.*;

/**
 *
 * @author Meilyn Juleisy Garcia Lima9959-23-17838
 */
public class clsCarrera {
    private int codigoCarrera;
    private String nombreCarrera;
    private String codigoFacultad;
    private String estatusCarrera;

    public clsCarrera() {
    }

    public clsCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public clsCarrera(String nombreCarrera, String codigoFacultad) {
        this.nombreCarrera = nombreCarrera;
        this.codigoFacultad = codigoFacultad;
    }

    public clsCarrera(String nombreCarrera, String codigoFacultad, String estatusCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.codigoFacultad = codigoFacultad;
        this.estatusCarrera = estatusCarrera;
    }

    public clsCarrera(int codigoCarrera, String nombreCarrera, String codigoFacultad, String estatusCarrera) {
        this.codigoCarrera = codigoCarrera;
        this.nombreCarrera = nombreCarrera;
        this.codigoFacultad = codigoFacultad;
        this.estatusCarrera = estatusCarrera;
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public String getCodigoFacultad() {
        return codigoFacultad;
    }

    public String getEstatusCarrera() {
        return estatusCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public void setCodigoFacultad(String codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public void setEstatusCarrera(String estatusCarrera) {
        this.estatusCarrera = estatusCarrera;
    }

    @Override
    public String toString() {
        return "clsCarrera{" + "codigoCarrera=" + codigoCarrera + ", nombreCarrera=" + nombreCarrera + ", codigoFacultad=" + codigoFacultad + ", estatusCarrera=" + estatusCarrera + '}';
    }

    
}

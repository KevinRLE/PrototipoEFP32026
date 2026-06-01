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
    private int percodigo;
    private String pernombre;
    private String perestado;

    public clsCarrera() {
    }

    public clsCarrera(int percodigo) {
        this.percodigo = percodigo;
    }

    public clsCarrera(String pernombre, String perestado) {
        this.pernombre = pernombre;
        this.perestado = perestado;
    }

    public clsCarrera(int percodigo, String pernombre, String perestado) {
        this.percodigo = percodigo;
        this.pernombre = pernombre;
        this.perestado = perestado;
    }

    public int getPercodigo() {
        return percodigo;
    }

    public void setPercodigo(int percodigo) {
        this.percodigo = percodigo;
    }

    public String getPernombre() {
        return pernombre;
    }

    public void setPernombre(String pernombre) {
        this.pernombre = pernombre;
    }

    public String getPerestado() {
        return perestado;
    }

    public void setPerestado(String perEstado) {
        this.perestado = perEstado;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "perCodigo=" + percodigo +
                ", perNombre=" + pernombre +
                ", perEstado=" + perestado +
                '}';
    }
}

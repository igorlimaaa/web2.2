/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.model;

import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class Consulta {
    private Usuario usuario;
    private Medico medico;
    private Date data;
    private Clinica clinica;
    private String especialidade;
    private Diagnostico diagnostico;
    private boolean atendida;
    
    public Consulta() {
    }

    public Consulta(Usuario usuario, Medico medico, Date data, Clinica clinica, String especialidade, Diagnostico diagnostico, boolean atendida) {
        this.usuario = usuario;
        this.medico = medico;
        this.data = data;
        this.clinica = clinica;
        this.especialidade = especialidade;
        this.diagnostico = diagnostico;
        this.atendida = atendida;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
    
}

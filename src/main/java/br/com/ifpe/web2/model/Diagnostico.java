/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Eduardo
 */

@Embeddable
public class Diagnostico implements Serializable {
    
    @Column
    private String diagnostico;
    
    @Column
    private String medicamentos;

    public Diagnostico() {
    }

    public Diagnostico(String diagnostico, String medicamentos) {
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    
    
}

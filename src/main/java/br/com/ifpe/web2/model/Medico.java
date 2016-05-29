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

public class Medico extends Usuario{
    private String crm;
    private String especialidade;
    
    public Medico() {
    }

    /*public Medico(String crm, String cpf, String nome, String sobrenome, char sexo, String email, String senha, Endereco endereco, Telefone telefone, Date dataNasc) {
        super(cpf, nome, sobrenome, sexo, email, senha, endereco, telefone, dataNasc);
        this.crm = crm;
    }*/

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
}

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
public class Endereco implements Serializable {
    
    @Column
    private String logradouro;
    
    @Column
    private String bairro;
    
    @Column
    private String cidade;
    
    @Column
    private String estado;
    
    @Column
    private int cep;

    public Endereco() {
    }

    public Endereco(String logradouro, String bairro, String cidade, String estado, int cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
    
    public String getEnderecoCompleto(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(logradouro);
        sb.append(", ");
        sb.append(bairro);
        sb.append(", ");
        sb.append(cidade);
        sb.append(" - ");
        sb.append(estado);
        
        return sb.toString();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.model;

/**
 *
 * @author Eduardo
 */
public class Telefone {
    private int ddd;
    private int numero;

    public Telefone() {
    }
    
    public Telefone(int ddd, int numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getNumeroFormatado(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("(");
        sb.append(ddd);
        sb.append(") ");
        sb.append(numero);
        
        return sb.toString();
    }
    
}

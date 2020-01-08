package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String tinta;
    private String cores;
    private double valor;
    private int quantidade;
    protected Product() {}
    public Product(String tinta, 
    double valor, int quantidade, String cores) {
        this.tinta = tinta;
        this.valor = valor;
        this.quantidade = quantidade;
        this.cores = cores;
    }

    /**
     * @return the tinta
     */
    public String getTinta() {
        return this.tinta;
    }
    /**
     * @param tinta the tinta to set
     */
    public void setTinta(String tinta) {
        this.tinta = tinta;
    }

    public double getValor() {
        return this.valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * @return the cores
     */
    public String getCores() {
        return cores;
    }
    /**
     * @param cores the cores to set
     */
    public void setCores(String cores) {
        this.cores = cores;
    }
	public Long getId() {
		return id;
	}

}

package br.iesb.livro;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_livro", nullable = false)   
    private int idLivro;
    @Column(name = "tx_titulo", nullable = false)   
    private String txTitulo;
    @Column(name = "tx_autor", nullable = false) 
    private String txAutor;
    @Column(name = "tx_paginas", nullable = false) 
    private String txPaginas;
    @Column(name = "tx_isbn", nullable = false) 
    private String txISBN;

    public Livro() {
    }

    public Livro(int idLivro, String txTitulo, String txAutor, String txPaginas, String txISBN) {
        this.idLivro = idLivro;
        this.txTitulo = txTitulo;
        this.txAutor = txAutor;
        this.txPaginas = txPaginas;
        this.txISBN = txISBN;
    }

    public String getTxISBN() {
        return txISBN;
    }

    public void setTxISBN(String txISBN) {
        this.txISBN = txISBN;
    }

    public String getTxTitulo() {
        return txTitulo;
    }

    public void setTxTitulo(String txTitulo) {
        this.txTitulo = txTitulo;
    }

    public String getTxAutor() {
        return txAutor;
    }

    public void setTxAutor(String txAutor) {
        this.txAutor = txAutor;
    }

    public String getNiPaginas() {
        return txPaginas;
    }

    public void setNiPaginas(String txPaginas) {
        this.txPaginas = txPaginas;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTxPaginas() {
        return txPaginas;
    }

    public void setTxPaginas(String txPaginas) {
        this.txPaginas = txPaginas;
    }

}

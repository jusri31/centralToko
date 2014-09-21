/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author yuzri
 */
@Entity
@Table(name="TBL_SALES_DETAIL")
public class SalesDetail implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_SALES_DETAIL")
    private Long id;
    @Column(name="JUMLAH")
    private Integer jumlah;
    @Column(name="SUB_TOTAL")
    private BigDecimal subTotal;
    @ManyToOne
    @JoinColumn(name = "ID_SALES")
    private Sales sales;
    @ManyToOne
    @JoinColumn (name="ID_Produk")
    private Produk produk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }
    
    
}

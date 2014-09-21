/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model.transaksi;

import com.SCI.centraltoko.model.Produk;
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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author yuzri
 */
@Entity
@Table(name="TBL_PENJUALAN_DETAIL")
public class PenjualanDetail implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_PENJUALAN_DETAIL")
    private Long id;
    @Column (name="JUMLAH")
    private Integer jumlah;
    @Column(name="HARGA")
    private BigDecimal harga;
    @Column(name="SUB_TOTAL")
    private BigDecimal subTotal;
    @ManyToOne
    @JoinColumn(name = "ID_PENJUALAN",nullable = false)
    private Penjualan penjualan;
    @ManyToOne
    @JoinColumn(name = "ID_PRODUK",referencedColumnName = "ID_PRODUK")
    @Cascade(CascadeType.SAVE_UPDATE)
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

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }
    
    
}

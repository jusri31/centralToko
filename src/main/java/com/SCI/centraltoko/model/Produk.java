/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model;

import com.SCI.centraltoko.model.transaksi.Pembelian;
import com.SCI.centraltoko.model.transaksi.Penjualan;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author yuzri
 */
@Entity
@Table(name = "TBL_PRODUK",uniqueConstraints = {@UniqueConstraint(columnNames = {"NAMA"})})
public class Produk implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRODUK")
    private Long id;
    @Column(name = "KODE_PRODUK",length = 100)
    private String kode;
    @Column(name = "NAMA",length = 200,unique = true)
    private String nama;
    @Column(name="HARGA_BELI")
    private BigDecimal hBeli = BigDecimal.ZERO;
    @Column(name="HARGA_JUAL")
    private BigDecimal hJual= BigDecimal.ZERO; 
    @Column(name="STOK",length = 10)
    private Integer stok=0;
   

    public Long getId() {        
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public BigDecimal gethBeli() {
        return hBeli;
    }

    public void sethBeli(BigDecimal hBeli) {
        this.hBeli = hBeli;
    }

    public BigDecimal gethJual() {
        return hJual;
    }

    public void sethJual(BigDecimal hJual) {
        this.hJual = hJual;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }
    
    
    
}

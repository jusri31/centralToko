/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model.transaksi;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author yuzri
 */
@Entity
@Table(name="TBL_PEMBELIAN")
public class Pembelian implements Serializable {
    @Id 
    
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
   
    @Temporal(TemporalType.DATE)
    @Column(name="TGL_BELI")
    private Date tgl_beli;
    
    @Column(name="TOTAL")
    private BigDecimal total;
//    tamabah fetch = FetchType.EAGER untuk mengatasi problem ini Exception in thread "AWT-EventQueue-0" org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.SCI.centraltoko.model.transaksi.Pembelian.pembelianDetail, could not initialize proxy - no Session
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pembelian")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<PembelianDetail> pembelianDetail;
   
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTgl_beli() {
        return tgl_beli;
    }

    public void setTgl_beli(Date tgl_beli) {
        this.tgl_beli = tgl_beli;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    @SuppressWarnings("Convert2Diamond")
   public void addDetail(PembelianDetail detail){
        if(pembelianDetail == null){
            pembelianDetail = new ArrayList<PembelianDetail>();
        }
        detail.setPembelian(this);
        pembelianDetail.add(detail);
    }
   
    public List<PembelianDetail> getPembelianDetail() {
        
        return pembelianDetail;
    }

    public void setPembelianDetail(List<PembelianDetail> pembelianDetail) {
        this.pembelianDetail = pembelianDetail;
       if(pembelianDetail!=null && !pembelianDetail.isEmpty()){
            for(PembelianDetail detail : pembelianDetail){
                detail.setPembelian(this);
               
            }
        }
    }

 
    
}

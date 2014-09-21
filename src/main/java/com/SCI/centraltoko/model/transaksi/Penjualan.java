/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model.transaksi;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="TBL_PENJUALAN")
public class Penjualan implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_JUAL")
    private Long id;
   
    @Temporal(TemporalType.DATE)
    @Column(name="TGL_JUAL")
    private Date tglJual;
    @Column(name="TOTAL")
    private BigDecimal total;
  
    //    tamabah fetch = FetchType.EAGER untuk mengatasi problem ini Exception in thread "AWT-EventQueue-0" org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.SCI.centraltoko.model.transaksi.Pembelian.pembelianDetail, could not initialize proxy - no Session
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "penjualan",fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<PenjualanDetail> penjualanDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getTglJual() {
        return tglJual;
    }

    public void setTglJual(Date tglJual) {
        this.tglJual = tglJual;
    }


    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


    public List<PenjualanDetail> getPenjualanDetail() {
        return penjualanDetail;
    }

    public void setPenjualanDetail(List<PenjualanDetail> penjualanDetail) {
        this.penjualanDetail = penjualanDetail;
        if(penjualanDetail !=null && !penjualanDetail.isEmpty()){
            for(PenjualanDetail detail : penjualanDetail){
                detail.setPenjualan(this);
            }
        }
    }
    
    
    
}

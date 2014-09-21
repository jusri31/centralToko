/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author yuzri
 */
@Entity
@Table(name="TBL_SALES")
public class Sales implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_SALES")
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name="TGL_SALES")
    private Date tglSales;
    @Column(name="TOTAL_SALES")
    private BigDecimal totalSales;
    @ManyToOne
    @JoinColumn(name="ID_PERSON",referencedColumnName = "ID_PERSON")
    private Person person;
    @OneToMany(cascade =CascadeType.ALL,mappedBy = "sales" )
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<SalesDetail> salesDetai;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTglSales() {
        return tglSales;
    }

    public void setTglSales(Date tglSales) {
        this.tglSales = tglSales;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<SalesDetail> getSalesDetai() {
        return salesDetai;
    }

    public void setSalesDetai(List<SalesDetail> salesDetai) {
        this.salesDetai = salesDetai;
    }
    
    
    
}

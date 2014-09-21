/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yuzri
 */
@Entity
@Table(name = "TBL_PERSON")
public class Person implements  Serializable {
    
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PERSON")
    private Long id;
    
    
    @Column(name = "NAMA",length = 100,unique = true)
    private String nama;
    
    @Column(name="PASSWORD",length = 200,unique = true)
    private String password;
    
    @Lob
    @Column(name="ALAMAT")
    private String alamat;
    
    @Temporal(TemporalType.DATE)
    @Column(name="BIRT_DATE")
    private Date birthDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name="STATUS",length = 20)
    private MarialStstus status;
    
    @Lob
    @Column(name="PICTURE")
    private byte [] picture;
   

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public MarialStstus getStatus() {
        return status;
    }

    public void setStatus(MarialStstus status) {
        this.status = status;
    }  
    
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.service;

import com.SCI.centraltoko.model.Person;
import com.SCI.centraltoko.model.Produk;
import com.SCI.centraltoko.model.Sales;
import com.SCI.centraltoko.model.SalesDetail;
import java.util.List;

/**
 *
 * @author yuzri
 */
public interface MasterService {
    
    public Person simpan(Person p);
    public Person hapus(Person p);
    public Person getIdPerson(Long id);
    public Long totalPerson();
    public List<Person> semuaPerson();
    public List<Person> semuaPersonDari(int star,int num);
    public Person login(String nm);
    
    
    public Produk simpan(Produk p);
    public Produk hapus(Produk p);
    public Produk getIdProduk(long id);
    public Long totalProduk();
    public List<Produk> semuaProduk();
    public List<Produk> semuaProdukDari(int star,int num);
    
   
    
    public Sales simpan(Sales s);
    public Sales hapus(Sales s);
    public Sales getIdSales(long id);
    public Long jumlahSales();
    public List<Sales> semuaSales();
    public List<Sales> semuaSalesDari(int star,int num);
    
    public SalesDetail simpan(SalesDetail s);
    public SalesDetail hapus(SalesDetail s);
    public SalesDetail getIdSalesDetai(long id);
    public Long jumlahSalesDetail();
    public List<SalesDetail> semuaSalesDetail();
    public List<SalesDetail> semuaSalesDetailDari(int star,int num);
    
}
    


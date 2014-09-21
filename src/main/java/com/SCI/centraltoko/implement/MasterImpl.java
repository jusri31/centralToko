/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.implement;

import com.SCI.centraltoko.model.Person;
import com.SCI.centraltoko.model.Produk;
import com.SCI.centraltoko.model.Sales;
import com.SCI.centraltoko.model.SalesDetail;
import com.SCI.centraltoko.model.dao.master.PersonDao;
import com.SCI.centraltoko.model.dao.master.ProdukDao;
import com.SCI.centraltoko.model.dao.master.SalesDao;
import com.SCI.centraltoko.model.dao.master.SalesDetailDao;
import com.SCI.centraltoko.service.MasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yuzri
 */
@Service( value = "masterService" )
@Transactional(readOnly = true)

public class MasterImpl implements MasterService{
    
    @Autowired
    private PersonDao personDao;
    
    @Autowired 
    private ProdukDao produkDao;
  
    @Autowired 
    private SalesDao salesDao;
    @Autowired 
    private SalesDetailDao salesDetailDao;
    
    
    //implementasi person
    @Transactional
    @Override
    public Person simpan(Person p) {
        return personDao.save(p);
        
    }
    @Transactional
    @Override
    public Person hapus(Person p) {
        return personDao.hapus(p);
    }

    @Override
    public Person getIdPerson(Long id) {
        return personDao.getId(id);
    }

    @Override
    public Long totalPerson() {
        return personDao.count();
    }
   
    @Override
    public List<Person> semuaPerson() {
        return personDao.getAll();
    }

    @Override
    public List<Person> semuaPersonDari(int star, int num) {
        return personDao.getAll(star, num);
    }
    
    

    
    // IMplementasi produk
    @Transactional
    @Override
    public Produk simpan(Produk p) {
       return produkDao.save(p);
    }
    @Transactional
    @Override
   public Produk hapus(Produk p) {
        return produkDao.hapus(p);
    }

    @Override
    public Produk getIdProduk(long id) {
        return produkDao.getId(id);
    }

    @Override
    public Long totalProduk() {
        return produkDao.count();
    }

    @Override
    public List<Produk> semuaProduk() {
        return produkDao.getAll();
    }

    @Override
    public List<Produk> semuaProdukDari(int star, int num) {
        return produkDao.getAll(star, num);
    }

    
    
   

    
    //Implementasi Sales
    @Transactional
    @Override
    public Sales simpan(Sales s) {
        return salesDao.save(s);
    }
    @Transactional
    @Override
    public Sales hapus(Sales s) {
        return salesDao.hapus(s);
    }

    @Override
    public Sales getIdSales(long id) {
        return salesDao.getId(id);
    }

    @Override
    public Long jumlahSales() {
        return salesDao.count();
    }

    @Override
    public List<Sales> semuaSales() {
        return salesDao.getAll();
    }

    @Override
    public List<Sales> semuaSalesDari(int star, int num) {
        return salesDao.getAll(star, num);
    }

    
//    IMplementasi Sales Detail
    @Transactional
    @Override
    public SalesDetail simpan(SalesDetail s) {
        return salesDetailDao.save(s);
    }
    @Transactional
    @Override
    public SalesDetail hapus(SalesDetail s) {
        return salesDetailDao.hapus(s);
    }

    @Override
    public SalesDetail getIdSalesDetai(long id) {
        return salesDetailDao.getId(id);
    }

    @Override
    public Long jumlahSalesDetail() {
        return salesDetailDao.count();
    }

    @Override
    public List<SalesDetail> semuaSalesDetail() {
        return salesDetailDao.getAll();
    }

    @Override
    public List<SalesDetail> semuaSalesDetailDari(int star, int num) {
        return salesDetailDao.getAll(star, num);
    }

    @Override
    public Person login(String nm) {
        return personDao.login(nm);
    }

}
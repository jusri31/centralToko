/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.implement;

import com.SCI.centraltoko.model.dao.transaksi.PembelianDao;
import com.SCI.centraltoko.model.dao.transaksi.PembelianDetailDao;
import com.SCI.centraltoko.model.dao.transaksi.PenjualanDao;
import com.SCI.centraltoko.model.dao.transaksi.PenjualanDetaiDao;
import com.SCI.centraltoko.model.transaksi.Pembelian;
import com.SCI.centraltoko.model.transaksi.PembelianDetail;
import com.SCI.centraltoko.model.transaksi.Penjualan;
import com.SCI.centraltoko.model.transaksi.PenjualanDetail;
import com.SCI.centraltoko.service.TransaksiSevice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yuzri
 */
@Service("transaksiSevice")
@Transactional(readOnly = true)
public class TransaksiImpl implements TransaksiSevice{
    
    @Autowired private PembelianDao pembelianDao;
    @Autowired private PembelianDetailDao pembelianDetailDao;
    @Autowired private PenjualanDao penjualanDao;
    @Autowired private PenjualanDetaiDao penjualanDetailDao;
    
    

//    Implementasi Transaki Pembelian
    @Transactional(readOnly = false)
    @Override
    public Pembelian simpan(Pembelian p) {
        return pembelianDao.save(p);
    }
    
    @Transactional(readOnly = false)
    @Override
    public Pembelian hapus(Pembelian p) {
        return pembelianDao.hapus(p);
    }
  
        
 
    @Override
    public Pembelian getIdPembelian(Long id) {
        return pembelianDao.getId(id);
        
        
    }

    @Override
    public Long jumlahPembelian() {
        return pembelianDao.count();
    }

    @Override
    public List<Pembelian> semuaPembelian() {
        return pembelianDao.getAll();
    }

    @Override
    public List<Pembelian> semuaPembelianDari(int star, int num) {
        return pembelianDao.getAll(star, num);
    }
    
    
//  Implementasi Pembelian detail
    @Transactional
    @Override
    public PembelianDetail simpan(PembelianDetail p) {
        return pembelianDetailDao.save(p);
    }
    @Transactional
    @Override
    public PembelianDetail hapus(PembelianDetail p) {
        return pembelianDetailDao.hapus(p);
    }

    @Override
    public PembelianDetail getIdPembelianDetai(Long id) {
        return pembelianDetailDao.getId(id);
    }

    @Override
    public Long jumlahPembelianDetail() {
        return pembelianDetailDao.count();
    }

    @Override
    public List<PembelianDetail> semuaPembelianDetail() {
        return pembelianDetailDao.getAll();
    }

    @Override
    public List<PembelianDetail> semuaPembelianDetailDari(int star, int num) {
       return pembelianDetailDao.getAll(star, num);
    }
    

//  Implementasi Penjualan
    @Transactional
    @Override
    public Penjualan simpan(Penjualan p) {
        return penjualanDao.save(p);
    }
    @Transactional
    @Override
    public Penjualan hapus(Penjualan p) {
        return penjualanDao.hapus(p);
    }

    @Override
    public Penjualan getIdPenjualan(Long id) {
        return penjualanDao.getId(id);
    }

    @Override
    public Long jumlahPenjualan() {
        return penjualanDao.count();
    }

    @Override
    public List<Penjualan> semuaPenjualan() {
        return penjualanDao.getAll();
    }

    @Override
    public List<Penjualan> semuaPenjualanDari(int star, int num) {
        return penjualanDao.getAll(star, num);
    }

    
    
//  Implementasi penjualan detail
    @Transactional
    @Override
    public PenjualanDetail simpan(PenjualanDetail p) {
        return penjualanDetailDao.save(p);
    }
    
    @Transactional
    @Override
    public PenjualanDetail hapus(PenjualanDetail p) {
        return penjualanDetailDao.hapus(p);
    }

    @Override
    public PenjualanDetail getIdPenjualanDetai(Long id) {
        return penjualanDetailDao.getId(id);
    }

    @Override
    public Long jumlahPenjualanDetail() {
        return penjualanDetailDao.count();
    }

    @Override
    public List<PenjualanDetail> semuaPenjualanDetail() {
        return penjualanDetailDao.getAll();
    }

    @Override
    public List<PenjualanDetail> semuaPenjualanDetailDari(int star, int num) {
        return penjualanDetailDao.getAll(star, num);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.service;

import com.SCI.centraltoko.model.transaksi.Pembelian;
import com.SCI.centraltoko.model.transaksi.PembelianDetail;
import com.SCI.centraltoko.model.transaksi.Penjualan;
import com.SCI.centraltoko.model.transaksi.PenjualanDetail;
import java.util.List;

/**
 *
 * @author yuzri
 */
public interface TransaksiSevice {
    
    public Pembelian simpan(Pembelian p);
    public Pembelian hapus(Pembelian p);
    public Pembelian getIdPembelian(Long id);
    public Long jumlahPembelian();
    public List<Pembelian> semuaPembelian();
    public List<Pembelian> semuaPembelianDari(int star,int num);
    
    public PembelianDetail simpan(PembelianDetail p);
    public PembelianDetail hapus(PembelianDetail p);
    public PembelianDetail getIdPembelianDetai(Long id);
    public Long jumlahPembelianDetail();
    public List<PembelianDetail> semuaPembelianDetail();
    public List<PembelianDetail> semuaPembelianDetailDari(int star,int num);
    
    public Penjualan simpan(Penjualan p);
    public Penjualan hapus(Penjualan p);
    public Penjualan getIdPenjualan(Long id);
    public Long jumlahPenjualan();
    public List<Penjualan> semuaPenjualan();
    public List<Penjualan> semuaPenjualanDari(int star,int num);
    
    public PenjualanDetail simpan(PenjualanDetail p);
    public PenjualanDetail hapus(PenjualanDetail p);
    public PenjualanDetail getIdPenjualanDetai(Long id);
    public Long jumlahPenjualanDetail();
    public List<PenjualanDetail> semuaPenjualanDetail();
    public List<PenjualanDetail> semuaPenjualanDetailDari(int star,int num);
}

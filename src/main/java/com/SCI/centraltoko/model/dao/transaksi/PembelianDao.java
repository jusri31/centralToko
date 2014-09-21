/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model.dao.transaksi;

import com.SCI.centraltoko.model.dao.BaseDaoHibernate;
import com.SCI.centraltoko.model.transaksi.Pembelian;
import com.SCI.centraltoko.model.transaksi.PembelianDetail;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yuzri
 */
@Repository
public class PembelianDao extends BaseDaoHibernate<Pembelian> {
    @Override
    public Pembelian getId(Long id){
        Pembelian pembelian=(Pembelian)sessionFactory.getCurrentSession().get(Pembelian.class, id);
        if(pembelian !=null){
            Hibernate.initialize(pembelian.getPembelianDetail());
            for(PembelianDetail p : pembelian.getPembelianDetail()){
                Hibernate.initialize(p.getProduk());
            }
        }
        return pembelian;
    }
}

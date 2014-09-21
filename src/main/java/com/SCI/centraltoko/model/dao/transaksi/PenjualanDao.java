/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model.dao.transaksi;

import com.SCI.centraltoko.model.dao.BaseDaoHibernate;
import com.SCI.centraltoko.model.transaksi.Penjualan;
import com.SCI.centraltoko.model.transaksi.PenjualanDetail;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yuzri
 */
@Repository
public class PenjualanDao extends BaseDaoHibernate<Penjualan>{

    @Override
    public Penjualan getId(Long id) {
       Penjualan penjualan=(Penjualan)sessionFactory.getCurrentSession().get(Penjualan.class, id);
       if(penjualan !=null){
           Hibernate.initialize(penjualan.getPenjualanDetail());
           for(PenjualanDetail detail : penjualan.getPenjualanDetail()){
               Hibernate.initialize(detail.getProduk());
           }
       }
       return penjualan;
    }
    
}

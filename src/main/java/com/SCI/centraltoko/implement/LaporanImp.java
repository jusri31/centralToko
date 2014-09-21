/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.implement;

import com.SCI.centraltoko.model.MonthPembelianReport;
import com.SCI.centraltoko.service.Laporan;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yuzri
 */
@Service("laporan")
@Transactional(readOnly = true)
public class LaporanImp implements Laporan{
    private static final Logger log= LoggerFactory.getLogger(LaporanImp.class);
    @Autowired private SessionFactory sessionFactory;
    
    @Override
    public JasperPrint getMounthReportPenjualan(Date date) {
   
       try{
            List<MonthPembelianReport> pembelianReports=sessionFactory.getCurrentSession().createQuery("select s.produk.nama as namaProduk,"
                    + " sum(s.jumlah) as quantity, sum(s.subTotal) as subTotal from PembelianDetail s "
                    + " where month(s.pembelian.tgl_beli)=month(:date)"
                    + "group by s.produk.nama order by s.produk.nama ").setParameter("date", date).setResultTransformer(Transformers.aliasToBean(MonthPembelianReport.class)).list();
            InputStream is =LaporanImp.class.getResourceAsStream("/reports/monthPembelianReport.jasper");
            @SuppressWarnings("Convert2Diamond")
            Map<String,Object> parameter= new HashMap<String,Object>();
            parameter.put("date", date);
            
            return JasperFillManager.fillReport(is, parameter,new JRBeanCollectionDataSource(pembelianReports));
        }catch(JRException exception){
            log.error("Error generated monthPembelianReport", exception);
    }
    return null;
}
}

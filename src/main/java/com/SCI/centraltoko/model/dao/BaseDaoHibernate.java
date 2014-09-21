
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author yuzri
 * @param <T>
 */
public class BaseDaoHibernate<T> {
    @SuppressWarnings("unchecked")
    protected Class domainClass;
    
    @Autowired protected SessionFactory sessionFactory;
   
   
  
    @SuppressWarnings("unchecked")
    public BaseDaoHibernate() {
       this.domainClass=(Class)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        
    }
    
    public T  save(T domain){
        sessionFactory.getCurrentSession().saveOrUpdate(domain);
        return domain;
        
        
        
    }
    public T hapus(T domain){
        sessionFactory.getCurrentSession().delete(domain);
        return domain;
        
    }
    @SuppressWarnings("unchecked")
    public T getId(Long id){
        return(T) sessionFactory.getCurrentSession().get(domainClass, id);
    }
    @SuppressWarnings("unchecked")
    public Long count(){
        List list = sessionFactory.getCurrentSession().createQuery("select count(*) from " + domainClass.getName() + " x").list();
        Long count=(Long)list.get(0);
        return count;
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll(int start,int num){
        return sessionFactory.getCurrentSession().createQuery("from " + domainClass.getName()).setFirstResult(start*(num-1)).setMaxResults(num).list();
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll(){
        return sessionFactory.getCurrentSession().createQuery("from " + domainClass.getName()).list();
    }
}

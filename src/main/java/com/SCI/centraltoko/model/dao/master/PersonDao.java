/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SCI.centraltoko.model.dao.master;

import com.SCI.centraltoko.model.Person;
import com.SCI.centraltoko.model.dao.BaseDaoHibernate;

import org.springframework.stereotype.Repository;

/**
 *
 * @author yuzri
 */
@Repository
public class PersonDao extends BaseDaoHibernate<Person> {
    public Person login(String nm){
        return(Person) sessionFactory.getCurrentSession().createQuery("from Person p where p.nama = :name").setString("name",nm).uniqueResult();
    }
}

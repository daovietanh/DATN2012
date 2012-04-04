/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.generic.jpas.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author VietAnh
 */
public class jpaUtils {
    private EntityManagerFactory emf;
    private EntityManager em;
 
    public  EntityManagerFactory getEmf() {
        if(emf==null){
            emf = Persistence.createEntityManagerFactory("DA_ServerPU");
        }
        return emf;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return this.em=getEmf().createEntityManager();
    }
    
}

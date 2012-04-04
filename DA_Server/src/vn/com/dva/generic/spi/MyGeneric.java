/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.generic.spi;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import vn.com.dva.generic.api.IGenericAPI;
import vn.com.dva.generic.jpas.utils.jpaUtils;

/**
 *
 * @author VietAnh
 */
public class MyGeneric implements IGenericAPI {
    private EntityManager em ;
    jpaUtils jpu = new jpaUtils();
    public MyGeneric(){
        
    }
    @Override
    public boolean insertData(Object ob) {
        em = jpu.getEm();
        em.getTransaction().begin();
        try {
            em.persist(ob);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean updateData(Object ob) {
        em = jpu.getEm();
        em.getTransaction().begin();
        try {
            em.merge(ob);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean removeData(Class T, Long id) {
        em = jpu.getEm();
        em.getTransaction().begin();
        try {
            Object ob = em.find(T, id);
            em.remove(ob);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Object> getAllData(Class T) {
        List<Object> list = new ArrayList<Object> ();
        em = jpu.getEm();
        try {
             list = em.createQuery("Select ob from " + T.getSimpleName() + " ob ").getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return list;
    }
   
    
    
    @Override
    public List<Object> getData(Class T , String field) {
        List<Object> list = new ArrayList<Object> ();
        em = jpu.getEm();
        try {
             list = em.createQuery("Select ob from " + T.getSimpleName() + " ob where ob."+ field +" > 20").getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return list;
    }

    
    @Override
    public List getData1Field(Class T, Object field1 , Object key1) {
        List<Object> list = new ArrayList<Object> ();
        em = jpu.getEm();
        try {
             list = em.createQuery("Select tbl from " + T.getSimpleName() + " tbl where tbl."+ field1 + " = '" + key1 + "'" ).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return list;
    }
    
    @Override
    public List getData2Field(Class T, Object field1, Object field2 , Object key1 , Object key2) {
        List<Object> list = new ArrayList<Object> ();
        em = jpu.getEm();
        try {
             list = em.createQuery("Select tbl from " + T.getSimpleName() + " tbl where tbl."+ field1 + " = '" + key1 + "' and tbl."+ field2+ " = '"+ key2 +"'" ).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return list;
    }

    

}

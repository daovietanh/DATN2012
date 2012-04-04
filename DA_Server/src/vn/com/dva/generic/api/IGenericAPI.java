/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.generic.api;

import java.util.List;

/**
 *
 * @author VietAnh
 */
public interface IGenericAPI<E> {
    public boolean insertData(E ob);
    public boolean updateData(E ob);
    public boolean removeData(Class T, Long id);
    public List<E> getAllData(Class T) ;
    public List<E> getData(Class T, String field);
    public List<E> getData1Field(Class T, Object field1 , Object key);
    public List<E> getData2Field(Class T, Object field1 , Object field2 , Object key1 , Object key2);
    
}

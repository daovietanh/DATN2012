/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author VietAnh
 */
@Entity
public class LevelAll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long LevelAllID;
    private String levelName ;
    private String levelDescription ;
    private int percentEasy ;
    private int percentNormal ;
    private int percentHard ;
    
    public LevelAll(){
        
    }
    public Long getLevelAllID() {
        return LevelAllID;
    }

    public void setLevelAllID(Long id) {
        this.LevelAllID = id;
    }

    
    public String getLevelName(){
        return this.levelName;
    }
    
    public void setLevelName(String s){
        this.levelName = s ;
    }
    
    public String getLevelDescription(){
        return this.levelDescription ;
    }
    
    public void setLevelDescription(String s){
        this.levelDescription = s ;
    }
    
    public int getPercentEasy(){
        return this.percentEasy ;
    }
    
    public void setPercentEasy(int i){
        this.percentEasy = i ;
    }
    
    public int getPercentNormal(){
        return this.percentNormal ;
    }
    
    public void setPercentNormal(int i){
        this.percentNormal = i ;
    }
    
    public int getPercentHard(){
        return this.percentHard ;
    }
    
    public void setPercentHard(int i){
        this.percentHard = i ;
    }
     
    public LevelAll(Long id , String name , String d , int e, int n , int h){
        this.LevelAllID  = id ;
        this.levelName = name;
        this.levelDescription = d ;
        this.percentEasy = e ;
        this.percentNormal = n ;
        this.percentHard = h ;
    }
    
    public LevelAll(String name , String d , int e, int n , int h){
        this.levelName = name;
        this.levelDescription = d ;
        this.percentEasy = e ;
        this.percentNormal = n ;
        this.percentHard = h ;
    }
    
    @Override
    public String toString(){
      return this.levelName;  
    }
    
}

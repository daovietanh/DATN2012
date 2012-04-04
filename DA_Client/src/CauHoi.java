/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VietAnh
 */
public class CauHoi {
    String id ="";
    public int stt = 0;
    String dapan="" ;
    String noidung = "";
    String a="" ;
    String b="" ;
    String c="" ;
    String d="" ;
    String luachon ="";

    public String getId()
    {
        return id;
    }
    public String getDapAn()
    {
        return dapan;
    }
    public String getNoiDung()
    {
        return noidung;
    }
    public String getA()
    {
        return a;
    }
    public String getB()
    {
        return b;
    }
    public String getC()
    {
        return c;
    }
    public String getD()
    {
        return d;
    }
    public String getLuaChon()
    {
        return luachon;
    }
    public int getStt()
    {
        return stt;
    }

    //----------------------------
    public void setId(String i)
    {
        this.id = i;
    }
    public void setDapAn(String i)
    {
        this.dapan = i;
    }
    public void setNoiDung(String i)
    {
        this.noidung = i;
    }
    public void setA(String i)
    {
        this.a = i;
    }

    public void setB(String i)
    {
        this.b = i;
    }
    public void setC(String i)
    {
        this.c = i;
    }
    public void setD(String i)
    {
        this.d = i;
    }
    public void setLuaChon(String i)
    {
        this.luachon = i;
    }
    public void setStt(int i)
    {
        this.stt = i;
    }

    public boolean kiemtra(){
        if (this.luachon.equals(""))
            return false ;
        if (this.luachon.equals(this.dapan))
            return true;
        return false;
    }

}

package com.enestigli.webservice;

public class Personel {

    private String  Ad ;
    private String Soyad;
    private String PersonelNo;
    private String Yaptigi_is;

    public String getYaptigi_is() {
        return Yaptigi_is;
    }

    public void setYaptigi_is(String yaptigi_is) {
        Yaptigi_is = yaptigi_is;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;


    public String getName()
    {

        return Ad;
    }

    public void setName(String name)
    {

        this.Ad = name;
    }

    public String getLastName()
    {

        return Soyad;
    }

    public void setLastName(String lastName)
    {

        this.Soyad = lastName;
    }

    public String getPersonelID()
    {

        return PersonelNo;
    }

    public void setPersonelID(String personelID)
    {

        PersonelNo = personelID;
    }


}

package com.enestigli.webservice;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.enestigli.webservice.databinding.ActivityMainBinding;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.HttpsTransportSE;
import org.ksoap2.transport.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ServiceManagerPersonel {

    //Gerekli tanımlamaları yapalım
    //web service yazarken kullandığımız namesapce alanını yazalım
    public static final String NAMESPACE ="https://localhost:44397/api/";
    //methodumuzun adını yazalım
    public static final String METHOD_NAME_GETPRODUCT="GetAllCalisanlar";
    //Namespace ve method adını yazalım
    public static final String SOAP_ACTION_GETPRODUCT="https://localhost:44397/api/GetAllCalisanlar";
    //web servisimizi bağlayacağımız bağlantıyı yazalım
    public static final String URL = "https://localhost:44397/api/default?apiKey=8f7b2190-ce69-4310-9bf5-c657bd2a9f61";

    //soap Object tanımlayalım ve gerekli tanımlamaları yapalım
    public SoapObject request;

    public SoapSerializationEnvelope envelope;
    public HttpTransportSE httpTransportSE;
    public Personel personel;
    public List<Personel> personelList;

    ActivityMainBinding binding;


        public List<Personel> getPersonel(){

                personelList = new ArrayList<>();
                //soap objesini tanımlayalım.
                request = new SoapObject(NAMESPACE,METHOD_NAME_GETPRODUCT);

                //soap objesinin değerini verelim
                envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                //taşıma işlemini tanımlayalım
                httpTransportSE =  new HttpTransportSE(URL);
                httpTransportSE.debug=true;

                try{
                    //taşıma işleminin çağıralım
                    httpTransportSE.call(SOAP_ACTION_GETPRODUCT,envelope);
                    //soap üzerinden dönen cevabımızı alalım
                    SoapObject response = (SoapObject) envelope.getResponse();
                    //alınan cevaba göre değerlerimizi tek tek gezelim

                    for(int i=0;i<response.getPropertyCount();i++){

                        SoapObject responsePersonel = (SoapObject) response.getProperty(i);
                        Object PersonelName = (String) responsePersonel.getProperty("Ad");
                        Object PersonelLastName = (String) responsePersonel.getProperty("Soyad");
                        Object PersonelId = (String) responsePersonel.getProperty("personelNo");

                        personel = new Personel();
                        personel.setName(PersonelName.toString());
                        personel.setLastName(PersonelLastName.toString());
                        personel.setPersonelID(PersonelId.toString());
                        personelList.add(personel);
                        System.out.println("Name:"+personel.getName());

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            return personelList;

        }
    }





package com.enestigli.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.PrecomputedText;
import android.view.View;

import com.enestigli.webservice.databinding.ActivityMainBinding;

import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    List<Personel> personelList= new ArrayList<>();
    ServiceManagerPersonel SrvcMngPrsnl = new ServiceManagerPersonel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ServiceManagerPersonel serviceManagerPersonel = new ServiceManagerPersonel();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


            personelList = SrvcMngPrsnl.getPersonel();
            binding.textView.setText("LİST SİZE --> "+personelList.size());
            binding.textView.setText(personelList.toString());


    }

}


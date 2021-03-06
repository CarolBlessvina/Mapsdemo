package com.example.mymapsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {
     GoogleMap mMap;
     private static final int ERROR_DIALOG_REQUEST = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(servicesOK()){
            setContentView(R.layout.activity_map);
            Toast.makeText(this, " ready to map", Toast.LENGTH_SHORT).show();
        } else
        {
            setContentView(R.layout.activity_main);
        }
    }

    public boolean servicesOK(){
        int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS)
        {
            return true;

        } else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable)){
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable,this, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "cannot connect mapping service ", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}

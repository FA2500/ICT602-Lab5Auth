package com.example.lab5firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URLEncoder;

public class WhatsappActivity extends AppCompatActivity {

    Button waButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        waButton = (Button) findViewById(R.id.buttonWa);
    }

    public void waNumber(View view)
    {
        PackageManager packageManager = getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);
        String message = "Hello";
        String phone = "+601156403489";

        try
        {
            String url = "https://api.whatsapp.com/send?phone="+phone+"&text="+ URLEncoder.encode(message, "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if(i.resolveActivity(packageManager)!= null)
            {
                startActivity(i);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
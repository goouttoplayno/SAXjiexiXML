package com.example.saxjiexixml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String path = "http://10.62.61.107:8080/smyhvae.xml";
                        InputStream inputStream = HttpUtils.getXML(path);
                        try {
                            List<HashMap<String,String>> list = SaxService.readXML(inputStream, "person");
                            for (HashMap<String,String> map : list){
                                System.out.println(map.toString());
                            }
                        }catch (Exception e){

                        }
                    }
                });
                thread.run();
            }
        });
    }
}

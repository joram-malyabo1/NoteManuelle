package com.example.notemanuelle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Taxateur extends AppCompatActivity {

    Button btnNext, btnPrev;
    String myResponse;

    ListView lv;
    ArrayList<HashMap<String, String>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxateur);

        fetchTaxateurData();
        btnNext=findViewById(R.id.btnNext);
        btnPrev=findViewById(R.id.btnPrev);

        arrayList=new ArrayList<>();
        lv=(ListView)findViewById(R.id.listView);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Taxateur.this, AvisOrdonnateur.class);
                startActivity(intent);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Taxateur.this, Liquidation.class);
                onBackPressed();
            }
        });
    }

    private void fetchTaxateurData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiProvider.url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()){

                    myResponse = response.body().string();

                    //Log.e("RESPONSE", myResponse);

                    Taxateur.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject reader = new JSONObject(myResponse);
                                JSONArray superheros = reader.getJSONArray("data");
                                System.out.println("json size is : "+superheros.length());

                                for (int i=0; i<superheros.length();i++){

                                    JSONObject hero = superheros.getJSONObject(i);
                                    String name = hero.getString("nom");
                                    String postnom = hero.getString("postnom");
                                    String prenom = hero.getString("prenom");

                                    System.out.println(i+"Name :"+name+" Postnom : "+postnom +"Prenom: "+prenom);

                                    HashMap<String,String> data = new HashMap<>();
                                    data.put("nom",name);
                                    data.put("postnom", postnom);
                                    data.put("prenom", prenom);
                                    arrayList.add(data);
                                    ListAdapter adapter = new SimpleAdapter(Taxateur.this,
                                            arrayList,R.layout.listview_layout,new String[]{"nom","postnom","prenom"}, new int[]{R.id.nomTaxateur, R.id.postnomTaxateur, R.id.prenomTaxateur});
                                    lv.setAdapter(adapter);
                                }

                            }catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }
        });
    }
}

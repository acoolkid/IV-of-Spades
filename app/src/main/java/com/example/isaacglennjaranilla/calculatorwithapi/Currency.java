package com.example.isaacglennjaranilla.calculatorwithapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Currency extends AppCompatActivity {
    private String currencyAPI = "http://apilayer.net/api/live?";
    private String key = "0899fb4c5e237588d53529bc3ce0e371&";
    private String regions = "USD,AUD,CAD,PLN,MXN,PHP,CAD,,JYP&";
    private String format = "format=1";
    private String urlString = currencyAPI+key+regions+format;
    String[] contain = new String[100];
    private ListView theList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        theList = (ListView) findViewById(R.id.currencyList);
        new GetData().execute(urlString);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contain);
        theList.setAdapter(adapter);

    }


    public class GetData extends AsyncTask<String ,Void,Integer>{
        Integer result = 0;
        HttpURLConnection urlConnection;

        @Override
        protected Integer doInBackground(String... strings){
            try{
                URL url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                int statusCode = urlConnection.getResponseCode();
                if(statusCode==200){
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line=r.readLine())!=null){
                        response.append(line);
                    }
                    JSONObject reader = new JSONObject(response.toString());
                    String cList = reader.getString("quotes");

                    result = 1;
                }
            }
            catch (Exception e){
                Log.i("Connection portion",e.getLocalizedMessage());

            }
            return result;
        }
    }
}

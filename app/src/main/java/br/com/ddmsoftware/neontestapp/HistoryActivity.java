package br.com.ddmsoftware.neontestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    Transfer transfers = new Transfer();

    ArrayList<Transfer> transfersArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        this.setTitle(getResources().getString(R.string.historicoEnvios));

        ListView listView = findViewById(R.id.myListViewHistory);

        transfersArrayList = getTransfers();

        listView.setAdapter(new ItemListHistoryAdapter(this, transfersArrayList));


        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {

            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Transfer> getTransfers(){

        final ArrayList<Transfer> transfersList = new ArrayList<>();

        AsyncTask.execute(new Runnable() {
                              @Override
                              public void run() {

                                  String url = "https://my-json-server.typicode.com/douglimar/NeonRESTMock/transfers";

                                  RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

                                  JsonObjectRequest jsonObject =new JsonObjectRequest(
                                          Request.Method.GET,
                                          url,
                                          null,

                                          new Response.Listener<JSONObject>() {

                                              @Override
                                              public void onResponse(JSONObject response) {

                                                  try {

                                                      JSONArray jsonArray = new JSONArray(response);

                                                      for (int i = 0; i < jsonArray.length(); i++ ) {

                                                          transfers = new Transfer();

                                                          JSONObject jsonTransfer = jsonArray.getJSONObject(i);

                                                          transfers.setClientId(jsonTransfer.getInt("ClienteId"));
                                                          transfers.setValor(jsonTransfer.getString("Valor"));
                                                          transfers.setToken(jsonTransfer.getString("Token"));
                                                          transfers.setData(jsonTransfer.getString("Data"));

                                                          /*
                                                          transfers.setClientId(response.getInt("ClienteId"));
                                                          transfers.setValor(response.get("Valor").toString());
                                                          transfers.setToken(response.get("Token").toString());
                                                          transfers.setData(response.get("Data").toString());
                                                          */
                                                          transfersList.add(transfers);
                                                      }

                                                      //Toast.makeText(getApplicationContext(), myToken, Toast.LENGTH_LONG).show();
                                                  } catch (JSONException e) {
                                                      e.printStackTrace();
                                                  }

                                              }
                                          },

                                          new Response.ErrorListener() {
                                              @Override
                                              public void onErrorResponse(VolleyError error) {
                                                  Log.e("Rest Response", error.toString());
                                              }
                                          }
                                  );

                                  requestQueue.add(jsonObject);

                              }
                          }

        );

        return transfersList;


    }


/*  private ArrayList<Transfer> getTransfers_v2(){

        final ArrayList<Transfer> transfersList = new ArrayList<>();

        AsyncTask.execute(new Runnable() {
                              @Override
                              public void run() {

                                  String url = "https://my-json-server.typicode.com/douglimar/NeonRESTMock/transfers/0";

                                  RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());


                                  JsonParser jsonParser = new JsonParser();

                                  String json = jsonParser.get("http://www.website/test.json");

                                  JsonObjectRequest jsonObject =new JsonObjectRequest(
                                          Request.Method.GET,
                                          url,
                                          null,

                                          new Response.Listener<JSONObject>() {

                                              @Override
                                              public void onResponse(JSONObject response) {

                                                  try {

                                                      for (int i = 0; i < response.length(); i++ ) {

                                                          transfers = new Transfer();

                                                          transfers.setClientId(response.getInt("ClienteId"));
                                                          transfers.setValor(response.get("Valor").toString());
                                                          transfers.setToken(response.get("Token").toString());
                                                          transfers.setData(response.get("Data").toString());

                                                          transfersList.add(transfers);
                                                      }


                                                      //Toast.makeText(getApplicationContext(), myToken, Toast.LENGTH_LONG).show();
                                                  } catch (JSONException e) {
                                                      e.printStackTrace();
                                                  }

                                              }
                                          },

                                          new Response.ErrorListener() {
                                              @Override
                                              public void onErrorResponse(VolleyError error) {
                                                  Log.e("Rest Response", error.toString());
                                              }
                                          }
                                  );

                                  requestQueue.add(jsonObject);

                              }
                          }

        );

        return transfersList;


    }

*/



}

package br.com.ddmsoftware.neontestapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_TOKEN  = "br.com.ddmsoftware.neontestapp.TOKEN";

    public String myToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Important code -- /Hide the action bar and show the fullscreen activity
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Button btnSendMoney = findViewById(R.id.btnSendMoney);
        Button btnHistory = findViewById(R.id.btnHistory);

        TextView tvClientName = findViewById(R.id.tvClient);
        TextView tvEmail = findViewById(R.id.tvEmail);

        final String clientName = tvClientName.getText().toString();
        final String email = tvEmail.getText().toString();

        btnSendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                generateToken();

                //generateTokenBackup();

                Intent intent = new Intent(MainActivity.this, SendMoneyActivity.class);
                intent.putExtra(EXTRA_MESSAGE_TOKEN, myToken);

                startActivity(intent);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                intent.putExtra(EXTRA_MESSAGE_TOKEN, myToken);

                startActivity(intent);

            }
        });

    }

    private String generateToken_old(final String userName, final String email){

        AsyncTask.execute(new Runnable() {
                              @Override
                              public void run() {


                                  String url = "https://my-json-server.typicode.com/douglimar/NeonRESTMock/generateToken?Username="+userName+"&e-mail=" + email ;


                                  //https://my-json-server.typicode.com/douglimar/NeonRESTMock/generateToken?Username=Douglimar%20Domingos%20de%20Moraes&e-mail=douglimar@email.com

                                  RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

                                  JsonObjectRequest jsonObject =new JsonObjectRequest(
                                          Request.Method.GET,
                                          url,
                                          null,
                                          new Response.Listener<JSONObject>() {

                                              @Override
                                              public void onResponse(JSONObject response) {

                                                  try {
                                                      myToken = response.get("Token").toString();

                                                      //Toast.makeText(getApplicationContext(), myToken, Toast.LENGTH_LONG).show();
                                                  } catch (JSONException e) {
                                                      e.printStackTrace();

                                                      Log.println(0,"Error: ", e.getMessage() );

                                                      //Log.e("ERROR ON GET: " + e.getMessage());
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


        return myToken;
    }

    private String generateTokenBKP(final String userName, final String email){

        //AsyncTask.execute(new Runnable() {
        //                    @Override
        //                  public void run() {


        String url = "https://my-json-server.typicode.com/douglimar/NeonRESTMock/generateToken?Username="+userName+"&e-mail=" + email ;


        //https://my-json-server.typicode.com/douglimar/NeonRESTMock/generateToken?Username=Douglimar%20Domingos%20de%20Moraes&e-mail=douglimar@email.com

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObject =new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            myToken = response.get("Token").toString();

                            //Toast.makeText(getApplicationContext(), myToken, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();

                            Log.println(0,"Error: ", e.getMessage() );

                            //Log.e("ERROR ON GET: " + e.getMessage());
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

        //                }
        //          }

        //);


        return url + "\n" + myToken;
    }

    private void generateToken(){

        AsyncTask.execute(new Runnable() {
                              @Override
                              public void run() {


                                  String url = "https://my-json-server.typicode.com/douglimar/NeonRESTMock/generateToken/0";

                                  //https://my-json-server.typicode.com/douglimar/NeonRESTMock/generateToken?Username=Douglimar%20Domingos%20de%20Moraes&e-mail=douglimar@email.com

                                  RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

                                  JsonObjectRequest jsonObject =new JsonObjectRequest(
                                          Request.Method.GET,
                                          url,
                                          null,
                                          new Response.Listener<JSONObject>() {

                                              @Override
                                              public void onResponse(JSONObject response) {

                                                  try {
                                                      myToken = response.get("Token").toString();

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


    }

    private void sendDataToServer() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", "douglimar");
        jsonObject.put("email", "douglimar@gmail.com");

    }
}

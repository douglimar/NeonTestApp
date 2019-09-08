package br.com.ddmsoftware.neontestapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

public class PopupSendMoneyActivity extends AppCompatActivity {

    private ArrayList<Client> clients;
    private String token;
    private EditText edtMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_send_money);

        TextView tvUserName = findViewById(R.id.tvPopupClientName);
        TextView tvPhoneNo = findViewById(R.id.tvPopupClientPhoneNo);
        edtMoney = findViewById(R.id.edtPopupValue);

        edtMoney.setText("");

        de.hdodenhof.circleimageview.CircleImageView imgUserPic = findViewById(R.id.imgPopupProfilePic);

        edtMoney.addTextChangedListener(new MoneyTextWatcher(edtMoney));

        Client client = new Client();
        clients = client.getAllClients(this);


        // Define PopUp layout
        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((width * 80) / 100, (height * 60) / 100);

        // Important code -- /Hide the action bar and show the fullscreen activity
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


        // get User Clicked -- Client that I will transfer money

        Intent intent = getIntent();

        int iDataPosition = (int) Objects.requireNonNull(intent.getExtras()).get("Position");
        token = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_TOKEN);

        //Toast.makeText(getBaseContext(), "SEND MONEY " + token, Toast.LENGTH_LONG).show();
        // Get Info from the Object
        String strUserName = clients.get(iDataPosition).getClientName();
        String strPhoneNo = clients.get(iDataPosition).getClientPhoneNo();
        int iUserPicture = clients.get(iDataPosition).getClientThumb();


        tvUserName.setText(strUserName);
        tvPhoneNo.setText(strPhoneNo);
        imgUserPic.setImageResource(iUserPicture);


        //Toast.makeText(getBaseContext(), "POSITION: >> " + iDataPosition, Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), strClickedClient, Toast.LENGTH_LONG).show();


        //intent.putExtra("USER",item);


        TextView txtClose;
        Button btnPopUpSendMoney;

        txtClose = findViewById(R.id.tvClose);
        btnPopUpSendMoney = findViewById(R.id.btnPopupSendMoney);


        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnPopUpSendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendMoney();

                finish();

                //JsonPostRequest();
                //Toast.makeText(getApplicationContext(), "Need to Implement", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void sendMoneyHttp() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                URL url = null;
                try {
                    url = new URL("https://my-json-server.typicode.com/douglimar/NeonRESTMock/transfers/");
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                    Log.e("HTTP ERROR", e.getMessage());

                }

                HttpURLConnection client = null;

                try {

                    /*
                    "id": 0,
                    "ClienteId": 10,
                    "Valor": 24,
                    "Token": "1d40d305-c836-43a2-b4db-acc56bcc1393",
                    "Data": "2016-08-02T14:25:37.55"
                     */

                    long ms = System.currentTimeMillis();
                    java.util.Date date = new java.util.Date(ms);

                    assert url != null;
                    client = (HttpURLConnection) url.openConnection();

                    client.setRequestMethod("POST");
                    client.setRequestProperty("id", "4");
                    client.setRequestProperty("ClientId", "10");
                    client.setRequestProperty("Valor", "350,33");
                    client.setRequestProperty("Token", token);
                    client.setRequestProperty("Data", date.toString());

                    String myData = "Token=" +token;

                    client.setDoOutput(true);

                    client.getOutputStream().write(myData.getBytes());

                    HttpResponseCache myCache = HttpResponseCache.install(getCacheDir(), 100000L);

                    if (myCache.getHitCount() > 0 ) {


                        Toast.makeText(getApplicationContext(), " Cache is working.", Toast.LENGTH_LONG).show();


                    }

                    // Redirect the output to the server
                    OutputStream outputStream = new BufferedOutputStream(client.getOutputStream());

                    //client.setFixedLengthStreamingMode(outputStream.toString().getBytes().length);
                    //client.setChunkedStreamingMode(0);


                    //writeStream(outputStream);
                    outputStream.flush();
                    outputStream.close();



                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("OPEN CONNECTION: ",  e.getMessage());
                } finally {

                    if (client !=null) {
                        client.disconnect();
                    }

                }




            }
        });


    }

    private void sendMoney() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    String address = "https://my-json-server.typicode.com/douglimar/NeonRESTMock/transfers/";
                    JSONObject json = new JSONObject();
                    //json.put("Title", "Dummy Title");
                    //json.put("Author", "Dummy Author");

                    long ms = System.currentTimeMillis();
                    java.util.Date date = new java.util.Date(ms);

                    json.put("id", "4");
                    json.put("ClientId", "10");
                    json.put("Valor", "350,33");
                    json.put("Token", token);
                    json.put("Data", date.toString());

                    String requestBody = json.toString();
                    URL url = new URL(address);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    OutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                    writer.write(requestBody);
                    writer.flush();
                    writer.close();
                    outputStream.close();

                    InputStream inputStream;
                    // get stream
                    if (urlConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
                        inputStream = urlConnection.getInputStream();
                    } else {
                        inputStream = urlConnection.getErrorStream();
                    }
                    // parse stream
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String temp, response = "";
                    while ((temp = bufferedReader.readLine()) != null) {
                        response += temp;
                    }
                    // put into JSONObject
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("Content", response);
                    jsonObject.put("Message", urlConnection.getResponseMessage());
                    jsonObject.put("Length", urlConnection.getContentLength());
                    jsonObject.put("Type", urlConnection.getContentType());

                    //return jsonObject.toString();

                } catch (IOException | JSONException e) {
                    //return e.toString();

                    Log.e("XXXX", e.getMessage());
                }

            }
        });


    }



/*
 public void sendMoney() {

        //final TextView mTextView = (TextView) findViewById(R.id.text);


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

*/


}

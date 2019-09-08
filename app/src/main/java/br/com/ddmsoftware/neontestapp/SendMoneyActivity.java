package br.com.ddmsoftware.neontestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SendMoneyActivity extends AppCompatActivity {

    public static ArrayList<Client> clientArrayList;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);
        this.setTitle(getResources().getString(R.string.enviar_dinheiro));


        Intent intent = getIntent();

        token = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_TOKEN);

        ListView listView = findViewById(R.id.myListView);

        Client client = new Client();

        clientArrayList = client.getAllClients(this);

        listView.setAdapter(new ItemListBaseAdapter(this, clientArrayList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                //Toast.makeText(SendMoneyActivity.this, "Item clicado: " + item, Toast.LENGTH_LONG).show();

                //Toast.makeText(getApplicationContext(), "VALOR EXTRA:" + token, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), PopupSendMoneyActivity.class);
                intent.putExtra("USER",item);
                intent.putExtra("Position",position);
                intent.putExtra(MainActivity.EXTRA_MESSAGE_TOKEN,token);


                startActivity(intent);

                //ShowPopUp(getBaseContext());
            }
        });

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
}

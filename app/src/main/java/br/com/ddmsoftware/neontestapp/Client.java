package br.com.ddmsoftware.neontestapp;

import android.content.Context;

import java.util.ArrayList;

public class Client {

    private int clientId;
    private String clientName;
    private String clientEmail;
    private String clientPhoneNo;
    private int clientThumb;


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getClientThumb() {
        return clientThumb;
    }

    public void setClientThumb(int clientThumb) {
        this.clientThumb = clientThumb;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhoneNo() {
        return clientPhoneNo;
    }

    public void setClientPhoneNo(String clientPhoneNo) {
        this.clientPhoneNo = clientPhoneNo;
    }

    public ArrayList<Client> getAllClients(Context context) {

        ArrayList<Client> clientsList = new ArrayList<>();

        Client client = new Client();

       // client.setClientId(1);
        client.setClientName("José Maria Eimael");
        client.setClientEmail("jose@email.com");
        client.setClientPhoneNo("+55 11 98765-8899");
        client.setClientThumb(R.drawable.client1);

        clientsList.add(client);

        client = new Client();

        //client.setClientId(2);
        client.setClientName("Maria das Flores de Oliveira");
        client.setClientEmail("dasflores@email.com");
        client.setClientPhoneNo("+55 11 96654-7811");
        client.setClientThumb(R.drawable.client2);

        clientsList.add(client);

        client = new Client();

        //client.setClientId(3);
        client.setClientName("Adelaide do Amaral ");
        client.setClientEmail("amaral@email.com");
        client.setClientPhoneNo("+55 11 32654-7841");
        client.setClientThumb(R.drawable.client4);

        clientsList.add(client);

        client = new Client();

        //client.setClientId(4);
        client.setClientName("Denis Rodman da Silva");
        client.setClientEmail("dr.rodman@email.com");
        client.setClientPhoneNo("+55 11 45787-54554");
        client.setClientThumb(R.drawable.client5);

        clientsList.add(client);

        client = new Client();

        client.setClientId(5);
        client.setClientName("Chiquinha Moderninha Couto e Silva");
        client.setClientEmail("moderninha@email.com");
        client.setClientPhoneNo("+55 11 2145-7865");
        client.setClientThumb(R.drawable.client6);

        clientsList.add(client);

        client = new Client();

        client.setClientId(6);
        client.setClientName("Barba Vintage Magalhaes");
        client.setClientEmail("obarba@email.com");
        client.setClientPhoneNo("+55 11 65879-7845");
        client.setClientThumb(R.drawable.client7);

        clientsList.add(client);

        client = new Client();

        client.setClientId(7);
        client.setClientName("Shirley dos Santos de Moraes");
        client.setClientEmail("shirmoraes@email.com");
        client.setClientPhoneNo("+55 11 7845-8745");
        client.setClientThumb(R.drawable.client8);

        clientsList.add(client);

        client = new Client();

        client.setClientId(8);
        client.setClientName("Cleiton Xavier ");
        client.setClientEmail("chaves@email.com");
        client.setClientPhoneNo("+55 11 32214-4778");
        client.setClientThumb(R.drawable.client9);

        clientsList.add(client);

        client = new Client();

        client.setClientId(9);
        client.setClientName("Tavares Marangoni Jr");
        client.setClientEmail("tavares@email.com");
        client.setClientPhoneNo("+55 11 2457-8772");
        client.setClientThumb(R.drawable.client17);

        clientsList.add(client);

        client = new Client();

        client.setClientId(10);
        client.setClientName("Roberto Junior");
        client.setClientEmail("rjunior@email.com");
        client.setClientPhoneNo("+55 11 32214-4778");
        client.setClientThumb(R.drawable.client11);

        clientsList.add(client);

        client = new Client();

        client.setClientId(11);
        client.setClientName("Mauricio J. Rivereto");
        client.setClientEmail("rivereto@email.com");
        client.setClientPhoneNo("+55 11 8879-4478");
        client.setClientThumb(R.drawable.client12);

        clientsList.add(client);

        client = new Client();

        client.setClientId(12);
        client.setClientName("Marcelo Schumacker");
        client.setClientEmail("schuma@email.com");
        client.setClientPhoneNo("+55 15 4578-9987");
        client.setClientThumb(R.drawable.client13);

        clientsList.add(client);

        client = new Client();

        client.setClientId(13);
        client.setClientName("André Monteiro");
        client.setClientEmail("andre@email.com");
        client.setClientPhoneNo("+55 92 7788-1245");
        client.setClientThumb(R.drawable.client14);

        clientsList.add(client);

        client = new Client();

        client.setClientId(14);
        client.setClientName("Lydiana Silva Souza");
        client.setClientEmail("lydi@email.com");
        client.setClientPhoneNo("+55 92 3322-76565");
        client.setClientThumb(R.drawable.client15);

        clientsList.add(client);

        client = new Client();

        client.setClientId(15);
        client.setClientName("Roberta Arcoverde ");
        client.setClientEmail("arcoverde@email.com");
        client.setClientPhoneNo("+55 11 2244-9988");
        client.setClientThumb(R.drawable.client16);

        clientsList.add(client);

        client = new Client();

        client.setClientId(16);
        client.setClientName("Juliana Ponzilacla ");
        client.setClientEmail("ponzi@email.com");
        client.setClientPhoneNo("+55 11 2145-9644");
        client.setClientThumb(R.drawable.client17);

        clientsList.add(client);

        client = new Client();

        client.setClientId(17);
        client.setClientName("Alexandre Ottoni ");
        client.setClientEmail("jnerd@email.com");
        client.setClientPhoneNo("+55 11 6654-7812");
        client.setClientThumb(R.drawable.client18);

        clientsList.add(client);

        client = new Client();

        client.setClientId(18);
        client.setClientName("Vanessa Lourenço de Moraes ");
        client.setClientEmail("vanessa@email.com");
        client.setClientPhoneNo("+55 15 93145-7879");
        client.setClientThumb(R.drawable.client8);

        clientsList.add(client);

        client = new Client();

        client.setClientId(19);
        client.setClientName("Larissa Lourenço");
        client.setClientEmail("larissa@email.com");
        client.setClientPhoneNo("+55 11 32214-4778");
        client.setClientThumb(R.drawable.client20);

        clientsList.add(client);

        client = new Client();

        client.setClientId(20);
        client.setClientName("Jean Pierre Magualdi ");
        client.setClientEmail("jpierre@email.com");
        client.setClientPhoneNo("+55 11 63211-77884");
        client.setClientThumb(R.drawable.client22);

        clientsList.add(client);

        return clientsList;

    }
}

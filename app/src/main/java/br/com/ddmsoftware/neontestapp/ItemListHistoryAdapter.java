package br.com.ddmsoftware.neontestapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by douglimar on 07/09/2019.
 * not default file
 */

public class ItemListHistoryAdapter extends BaseAdapter {

    private static ArrayList<Transfer> transferArrayList;
    private final LayoutInflater layoutInflater;

    public ItemListHistoryAdapter(Context context, ArrayList<Transfer> myTransferList) {

        transferArrayList = myTransferList;
        layoutInflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return transferArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return transferArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderView holderView;

        if (convertView==null){

            convertView = layoutInflater.inflate(R.layout.item_row, null);
            holderView = new HolderView();

            holderView.tvClientName = convertView.findViewById(R.id.tvItemRowClientName);
            holderView.tvClientPhoneNo = convertView.findViewById(R.id.tvItemRowClientPhoneNo);
            holderView.imgItemRowProfile = convertView.findViewById(R.id.imageItemRowProfile);

            convertView.setTag(holderView);

        } else {

            holderView = (HolderView) convertView.getTag();

        }

        holderView.tvClientName.setText(transferArrayList.get(position).getClientName());
        holderView.tvClientPhoneNo.setText(transferArrayList.get(position).getClientPhoneNo());
        holderView.imgItemRowProfile.setImageResource(transferArrayList.get(position).getClientThumb());

        return convertView;
    }

    static class HolderView {
        TextView tvClientName;
        TextView tvClientPhoneNo;
        ImageView imgItemRowProfile;
    }
}

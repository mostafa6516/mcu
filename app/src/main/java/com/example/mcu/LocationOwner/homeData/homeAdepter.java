package com.example.mcu.LocationOwner.homeData;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcu.Ip.And.Ordernum.model.ipandordermodel;
import com.example.mcu.R;

import java.util.List;

public class homeAdepter extends RecyclerView.Adapter<homeAdepter.ViewHolder> {

    private List<ipandordermodel> list;
    private Context context;

    public homeAdepter(List<ipandordermodel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ips_and_orders, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.set_ips(list.get(position).getIp());
        holder.set_order_number(list.get(position).getOrder());
        holder.ic_setting.setOnClickListener(v -> {
            showAlert(list.get(position).getIp());
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView ipnum;
        TextView ord_num;
       ImageView ic_setting;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ic_setting = itemView.findViewById(R.id.icon_ip_setting);
            ipnum = itemView.findViewById(R.id.user_ip_home);
            ord_num = itemView.findViewById(R.id.order_num_home);

        }

        void set_ips(String ip) {


                ipnum.setText(String.valueOf(ip));


        }


        void set_order_number(int order) {
            ord_num.setText(String.valueOf(order));
        }
    }
    void showAlert(String ip) {
        new AlertDialog.Builder(this.context)
                .setTitle(ip)
                .setMessage("Are you sure you want to control this IP?")
                .setIcon(R.drawable.ic_attention)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent =new Intent(context,retailer_ip_settingActivity.class);
                        intent.putExtra("ip", ip);
                        context.startActivity(intent);
                    }
                })
                .setNegativeButton("No", null)
                .create().show();
    }
}

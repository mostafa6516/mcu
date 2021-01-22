 package com.example.mcu.LocationOwner.homeData;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcu.Ip.And.Ordernum.model.ipandordermodel;
import com.example.mcu.R;

import java.util.List;

public class homeAdepter extends RecyclerView.Adapter<homeAdepter.ViewHolder> {

    private List<ipandordermodel> list;


    public homeAdepter(FragmentActivity activity, List<ipandordermodel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ips_and_orders, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.set_ips(list.get(position).getIp());

        holder.set_ips(String.valueOf(list.get(position).getOrder()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView ipnum;
        TextView ord_num;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            ipnum = itemView.findViewById(R.id.user_ip_home);
            ord_num = itemView.findViewById(R.id.order_num_home);

        }

        void set_ips(String ip) {

            if (ip != null) {

                ipnum.setText(String.valueOf(ip));

            } else {
                Log.e("error", "null");
            }


        }


        void set_order_number(int order) {

            ord_num.setText(order);


        }
    }
}

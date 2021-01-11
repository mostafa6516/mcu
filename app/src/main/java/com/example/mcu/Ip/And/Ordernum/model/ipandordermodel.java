package com.example.mcu.Ip.And.Ordernum.model;

import androidx.fragment.app.FragmentActivity;

import java.util.List;

public class ipandordermodel {


    private double ip;
    private int order;


    public ipandordermodel ( double ip, int order ) {
        this.ip = ip;
        this.order = order;
    }


    public double getIp () {
        return ip;
    }

    public void setIp ( double ip ) {
        this.ip = ip;
    }

    public int getOrder () {
        return order;
    }

    public void setOrder ( int order ) {
        this.order = order;
    }

    public ipandordermodel ( FragmentActivity activity, List < ipandordermodel > list ){




    }


}

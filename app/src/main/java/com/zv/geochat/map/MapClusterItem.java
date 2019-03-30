package com.zv.geochat.map;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class MapClusterItem implements ClusterItem {
    final LatLng mPosition;
    final String mTitle;
    final String mMessage;

    public MapClusterItem(double lat, double lng, String title, String message) {
        this.mPosition = new LatLng(lat, lng);
        this.mTitle = title;
        this.mMessage = message;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmMessage() {
        return mMessage;
    }
}

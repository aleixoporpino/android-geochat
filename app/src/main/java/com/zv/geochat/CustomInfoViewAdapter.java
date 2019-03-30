package com.zv.geochat;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoViewAdapter implements GoogleMap.InfoWindowAdapter {

    private final LayoutInflater mInflater;

    public CustomInfoViewAdapter(LayoutInflater inflater) {
        this.mInflater = inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        final View popup = mInflater.inflate(R.layout.info_window_layout, null);
        ((TextView) popup.findViewById(R.id.title)).setText(marker.getSnippet());
        return popup;
    }

    @Override
    public View getInfoContents(Marker marker) {
        final View popup = mInflater.inflate(R.layout.info_window, null);

        if (marker != null && marker.getTitle() != null) {
            System.out.println(marker.getSnippet());
            ((TextView) popup.findViewById(R.id.title)).setText(marker.getTitle());
        }

        return popup;
    }
}

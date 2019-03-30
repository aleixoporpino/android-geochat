package com.zv.geochat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;
import com.zv.geochat.map.MapClusterItem;

public class CustomClusterRenderer extends DefaultClusterRenderer<MapClusterItem> {

    private final IconGenerator mClusterIconGenerator;
    private final Context mContext;

    public CustomClusterRenderer(Context context, GoogleMap map,
                                 ClusterManager<MapClusterItem> clusterManager) {
        super(context, map, clusterManager);

        mContext = context;
        mClusterIconGenerator = new IconGenerator(mContext.getApplicationContext());
    }

    @Override
    protected void onBeforeClusterItemRendered(MapClusterItem item,
                                               MarkerOptions markerOptions) {
        Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(),
                R.drawable.ic_chat_bubble);
        Bitmap b = Bitmap.createScaledBitmap(icon, 100, 100, false);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(b)).snippet(item.getmTitle());
    }

    @Override
    protected void onBeforeClusterRendered(Cluster<MapClusterItem> cluster,
                                           MarkerOptions markerOptions) {

        mClusterIconGenerator.setBackground(
                ContextCompat.getDrawable(mContext, R.drawable.background_circle));

        mClusterIconGenerator.setTextAppearance(R.style.AppTheme_WhiteTextAppearance);

        final Bitmap icon = mClusterIconGenerator.makeIcon(String.valueOf(cluster.getSize()));
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
    }
}


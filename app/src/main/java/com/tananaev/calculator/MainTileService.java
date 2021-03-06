package com.tananaev.calculator;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

@TargetApi(Build.VERSION_CODES.N)
public class MainTileService extends TileService {

    @Override
    public void onStartListening() {
        ((MainApplication) getApplication()).setTile(getQsTile());
    }

    @Override
    public void onStopListening() {
        ((MainApplication) getApplication()).setTile(null);
    }

    @Override
    public void onClick() {
        if (getQsTile().getState() != Tile.STATE_ACTIVE) {
            ((MainApplication) getApplication()).showNotification();
        } else {
            ((MainApplication) getApplication()).hideNotification();
        }
    }

}

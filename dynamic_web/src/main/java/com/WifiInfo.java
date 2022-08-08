package com;

import java.lang.reflect.Array;

public class WifiInfo {
    private int list_total_count;
    private Result RESULT;
    private WifiService[] row;

    public WifiService[] GetWifiServices() {
        return this.row;
    }
}

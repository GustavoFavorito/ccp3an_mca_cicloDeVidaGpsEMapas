package br.usjt.ciclodevidagpsemapas;

import java.io.Serializable;

public class Localizacao implements Serializable {

    static final int REQUEST_CODE_GPS = 1001;
    private static long LOCATION_INTERVAL = 2 * 60 * 1000;
    private static int LOCATION_DISTANCE = 200;
    private static int LOCATION_MAX_SIZE = 50;
    private int id;
    private double latitude;
    private double longitude;

    public Localizacao() {

    }

    public Localizacao(int id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getRequestCodeGps() {
        return REQUEST_CODE_GPS;
    }

    public static long getLocationInterval() {
        return LOCATION_INTERVAL;
    }

    public static void setLocationInterval(long locationInterval) {
        LOCATION_INTERVAL = locationInterval;
    }

    public static int getLocationDistance() {
        return LOCATION_DISTANCE;
    }

    public static void setLocationDistance(int locationDistance) {
        LOCATION_DISTANCE = locationDistance;
    }

    public static int getLocationMaxSize() {
        return LOCATION_MAX_SIZE;
    }

    public static void setLocationMaxSize(int locationMaxSize) {
        LOCATION_MAX_SIZE = locationMaxSize;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
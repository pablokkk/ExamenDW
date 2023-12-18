package com.example.examendesarrollo.models;

public class Session {
    private static Examen_desarrollo parkingActual = null;

    public static Examen_desarrollo getExamenActual() {
        return parkingActual;
    }



    public static void setExamenActual(Examen_desarrollo parkingActual) {Session.parkingActual = parkingActual; }}



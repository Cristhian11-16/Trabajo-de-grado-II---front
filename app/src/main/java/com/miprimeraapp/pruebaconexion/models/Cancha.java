package com.miprimeraapp.pruebaconexion.models;

public class Cancha {
    private Long id_cancha;
    private String name;
    private int cant_canchas;
    private boolean futbol_5;
    private boolean futbol_8;
    private boolean parqueadero;
    private boolean cafeteria;
    private String imagen1;

    public Long getId_cancha() {
        return id_cancha;
    }

    public void setId_cancha(Long id_cancha) {
        this.id_cancha = id_cancha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCant_canchas() {
        return cant_canchas;
    }

    public void setCant_canchas(int cant_canchas) {
        this.cant_canchas = cant_canchas;
    }

    public boolean isFutbol_5() {
        return futbol_5;
    }

    public void setFutbol_5(boolean futbol_5) {
        this.futbol_5 = futbol_5;
    }

    public boolean isFutbol_8() {
        return futbol_8;
    }

    public void setFutbol_8(boolean futbol_8) {
        this.futbol_8 = futbol_8;
    }

    public boolean isParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(boolean parqueadero) {
        this.parqueadero = parqueadero;
    }

    public boolean isCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(boolean cafeteria) {
        this.cafeteria = cafeteria;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public Cancha(Long id_cancha, String name, int cant_canchas, boolean futbol_5, boolean futbol_8, boolean parqueadero, boolean cafeteria, String imagen1) {
        this.id_cancha = id_cancha;
        this.name = name;
        this.cant_canchas = cant_canchas;
        this.futbol_5 = futbol_5;
        this.futbol_8 = futbol_8;
        this.parqueadero = parqueadero;
        this.cafeteria = cafeteria;
        this.imagen1 = imagen1;
    }

    @Override
    public String toString() {
        return "Cancha{" +
                "id_cancha=" + id_cancha +
                ", name='" + name + '\'' +
                ", cant_canchas=" + cant_canchas +
                ", futbol_5=" + futbol_5 +
                ", futbol_8=" + futbol_8 +
                ", parqueadero=" + parqueadero +
                ", cafeteria=" + cafeteria +
                ", imagen1='" + imagen1 + '\'' +
                '}';
    }
}

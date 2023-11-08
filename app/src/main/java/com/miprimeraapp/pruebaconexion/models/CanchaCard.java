package com.miprimeraapp.pruebaconexion.models;

public class CanchaCard {

    private String name;
    private String direccion;
    private String barrio;
    private String localidad;
    private String precios;
    private String dia;
    private String logo;

    public CanchaCard(String name, String direccion, String barrio, String localidad, String precios, String dia, String logo) {
        this.name = name;
        this.direccion = direccion;
        this.barrio = barrio;
        this.localidad = localidad;
        this.precios = precios;
        this.dia = dia;
        this.logo = logo;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPrecios() {
        return precios;
    }

    public void setPrecios(String precios) {
        this.precios = precios;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public CanchaCard() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagenId() {
        return logo;
    }

    public void setImagenId(String logo) {
        this.logo = logo;
    }
}

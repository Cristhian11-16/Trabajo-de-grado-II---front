package com.miprimeraapp.pruebaconexion.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.miprimeraapp.pruebaconexion.R;
import com.miprimeraapp.pruebaconexion.constante.Constante;
import com.miprimeraapp.pruebaconexion.interfaces.ProductAPI;
import com.miprimeraapp.pruebaconexion.models.Cancha;
import com.miprimeraapp.pruebaconexion.models.CanchaAdapter;
import com.miprimeraapp.pruebaconexion.models.CanchaCard;
import com.miprimeraapp.pruebaconexion.models.Direccion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PantallaPrincipalFragment extends Fragment {
    CanchaAdapter canchaAdapter;
    RecyclerView recyclerViewCancha;
    ProductAPI productAPI;
    ArrayList<Cancha> cancha;
    ArrayList<CanchaCard> listaCancha;

    ArrayList<Direccion> listDireccion;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_pantalla_principal, container, false);
        recyclerViewCancha = view.findViewById(R.id.recyclerViewCancha);
        Button btnPrueba = view.findViewById(R.id.btnPrueba);
        btnPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getCanchasApi();
                //listaCancha.forEach(p->System.out.println(p.toString()));
                //getCanchasDireccionApi(1L);

            }
        });
        listaCancha= new ArrayList<>();
        getCanchasApi();
        getCanchasDireccionApi();
        //cargar lista
        //cargarLista();
        //mostrar datos
        return view;
    }
    private void mostrarData() {
        recyclerViewCancha.setLayoutManager(new LinearLayoutManager(getContext()));
        canchaAdapter = new CanchaAdapter(listaCancha, getContext());
        recyclerViewCancha.setAdapter(canchaAdapter);
    }

    private void cargarLista(ArrayList<Cancha> cancha, ArrayList<Direccion> listDireccion) {
        //listDireccion.forEach(p->System.out.println(p.toString()));
        String direccionCompleta;
        String barrio;
        String localidad;
        System.out.println(cancha.size());
        for (int i =0;i<cancha.size();i++){
            listaCancha.add(new CanchaCard(cancha.get(i).getName(),"Direccion: "+listDireccion.get(i).getTipo()+" "+listDireccion.get(i).getNum_tipo()+" "+listDireccion.get(i).getOrientacion()+" # "+listDireccion.get(i).getNum_calle()+"-"+listDireccion.get(i).getNum_casa(),"Barrio: "+listDireccion.get(i).getBarrio(),"Localidad: "+listDireccion.get(i).getLocalidad(),cancha.get(i).getName(),cancha.get(i).getName(),cancha.get(i).getImagen1()));

        }
        mostrarData();
        /*
        for (int i = 0; i< this.cancha.size(); i++){
            String name = this.cancha.get(i).getName();
            System.out.println(name);
            //listaCancha.add(new CanchaCard(cancha.get(i).getName().toString(),cancha.get(i).getName().toString(),cancha.get(i).getName().toString(),cancha.get(i).getName().toString(),cancha.get(i).getImagen1().toString()));
        }
        */
        //listaCancha.add(new CanchaCard("Cristhian", "Calle 30 sur","200","https://assets.goal.com/v3/assets/bltcc7a7ffd2fbf71f5/blt12dbddde5342ce4c/648866ff21a8556da61fa167/GOAL_-_Blank_WEB_-_Facebook_-_2023-06-13T135350.847.png?auto=webp&format=pjpg&width=3840&quality=60"));
        //listaCancha.add(new CanchaCard("Esteban", "Calle 30 sur","200","https://www.fcbarcelona.com/photo-resources/2020/04/30/43337a9f-3781-4886-948c-f70912e4b1af/1920x1080_Messi_primerGol-min.jpg?width=1200&height=750"));
        //listaCancha.add(new CanchaCard("gonzalez", "Calle 30 sur","200","https://www.futbolred.com/files/article_main/uploads/2023/09/07/64fa92b733634.jpeg"));


    }

    public void getCanchasApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constante.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        productAPI = retrofit.create(ProductAPI.class);
        Call<ArrayList<Cancha>> call = productAPI.getCanchas();
        call.enqueue(new Callback<ArrayList<Cancha>>() {
            @Override
            public void onResponse(Call<ArrayList<Cancha>> call, Response<ArrayList<Cancha>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "Fallo: "+response.message(), Toast.LENGTH_SHORT).show();
                }
                cancha = response.body();
                cancha.forEach(p->System.out.println(p.toString()));


            }


            @Override
            public void onFailure(Call<ArrayList<Cancha>> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo: "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void getCanchasDireccionApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constante.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        productAPI = retrofit.create(ProductAPI.class);
        Call<ArrayList<Direccion>> call = productAPI.getDireccion();
        call.enqueue(new Callback<ArrayList<Direccion>>() {
            @Override
            public void onResponse(Call<ArrayList<Direccion>> call, Response<ArrayList<Direccion>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "Fallo: "+response.message(), Toast.LENGTH_SHORT).show();
                }
                listDireccion = response.body();
                listDireccion.forEach(p->System.out.println(p.toString()));
                cargarLista(cancha,listDireccion);
            }

            @Override
            public void onFailure(Call<ArrayList<Direccion>> call, Throwable t) {

            }
            });
    }

}
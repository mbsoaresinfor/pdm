package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class FrutaAdapter extends ArrayAdapter<Fruta> {

    private List<Fruta> listaFruta;

    public FrutaAdapter(@NonNull Context context, List<Fruta> lista ) {
        super(context, 0,lista);
        listaFruta = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View view = convertView;
       if(view == null){
           Context ctx = getContext();
           LayoutInflater li = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view = li.inflate(R.layout.item_fruta,null);
       }
       Fruta fruta = listaFruta.get(position);
       TextView textViewiewNome = view.findViewById(R.id.textViewNomeFruta);
       TextView textViewiewPreco = view.findViewById(R.id.textViewPrecoFruta);
       textViewiewNome.setText(fruta.getNome());
       textViewiewPreco.setText(fruta.getPreco()+ "");
       return view;
    }
}

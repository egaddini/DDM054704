package com.ifsc.meuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FrutaAdapter extends ArrayAdapter<Fruta> {

    Context mContext;
    int mLayout;
    Fruta mFrutas[];

    public FrutaAdapter(@NonNull Context context, int resource, @NonNull Fruta[] objects) {
        super(context, resource, objects);
        mContext = context;
        mLayout = resource;
        mFrutas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(mLayout, parent, false);
        }
        Fruta fruta = getItem(position);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvNome = view.findViewById(R.id.textView);

        tvNome.setText(fruta.getNome());
        imageView.setImageResource(fruta.getImagem());

        return view;
    }

}

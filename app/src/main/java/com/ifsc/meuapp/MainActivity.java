package com.ifsc.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //public static String frutas[] = new String[] {"pera", "uva", "maça", "mamão"};

    public static ArrayList<String> frutas = new ArrayList<>();
    ListView listView;
    EditText editText;

    FrutaController frutaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        editText=findViewById(R.id.edtext);
        frutaController = new FrutaController();
        PackageManager packageManager;
        packageManager = getPackageManager();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), Integer.toString(i), Toast.LENGTH_LONG);
            }
        });


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                atualizarLista();
            }
        });
        atualizarLista();
    }

    public void atualizarLista(){
        listView.setAdapter(
                new FrutaAdapter(
                        getApplicationContext(),
                        R.layout.item_lista,
                        frutaController.FRUTAS
                )
        );
    }

}
package com.cerezo.adivinar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView nombre,bien,mal;
    int correcto = 0;
    int incorrecto = 0 ;
    String animal ="" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bien = findViewById(R.id.correcto);
        mal = findViewById(R.id.incorrecto);
        nombre = findViewById(R.id.nombre);

        generador();
    }
    String[] vec = {"Python", "Java","csharp","cplusplus","JavaScript","PHP","HTML","CSS","SQL"};
    void generador(){
        Random r = new Random();
        int p = r.nextInt(7);
        nombre.setText(vec[p]);
    }
    public void procesar(View v){
        ImageView ib = (ImageView) v;
        if (ib.getTag().equals(nombre.getText())){
            correcto++;
        } else {
            incorrecto++;
        }
        bien.setText(String.valueOf(correcto));
        mal.setText(String.valueOf(incorrecto));
        if (correcto >= 10){
            nombre.setText(" Ganaste ");
            reinicia();
            return;
        } else if (incorrecto >= 10){
            nombre.setText("Perdiste ");
            reinicia();
            return;
        }
        generador();
    }

    void reinicia (){
        correcto = 0;
        incorrecto = 0 ;
        bien.setText(String.valueOf(correcto));
        mal.setText(String.valueOf(incorrecto));
    }
    public void reinicio (View v){
        reinicia();
    }
}
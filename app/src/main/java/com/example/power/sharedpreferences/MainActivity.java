package com.example.power.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText nome;
    private EditText nomeGravado;
    private Button btnGravarNome;

    private String nomeEntrada;
    private static final String ARQUIVO_SALVAMENTO =" arquivoSalvamento ";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome=findViewById(R.id.editTextNome);
        nomeGravado=findViewById(R.id.editTextGravado);
        btnGravarNome=findViewById(R.id.btnGravar);

        btnGravarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences=getSharedPreferences(ARQUIVO_SALVAMENTO,0);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                if(nome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Éntre com o nome",Toast.LENGTH_SHORT).show();

                }

                else{

                    editor.putString("Nome" ,nome.getText().toString());
                    editor.commit();
                    nomeGravado.setText(nome.getText().toString());





                }


                }









        });
        SharedPreferences sharedPreferences=getSharedPreferences(ARQUIVO_SALVAMENTO,0);

        if(sharedPreferences.contains("Nome")){

            nomeEntrada=sharedPreferences.getString("primeiroNome","usuario nao existente");
            nomeGravado.setText(nomeEntrada);

        }
        else{

            nomeGravado.setText("Nome usuario ainda nao inserido");

        }


    }
}

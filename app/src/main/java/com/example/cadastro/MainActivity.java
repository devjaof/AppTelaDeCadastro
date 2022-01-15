package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText nome, idade, email;
    private RadioButton masculino, feminino, intersexo, prefiroNaoDizer;
    private TextView textNome, textIdade, textEmail, textSexo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        idade = findViewById(R.id.editIdade);
        email = findViewById(R.id.editEmail);

        masculino = findViewById(R.id.radioButtonMasc);
        feminino = findViewById(R.id.radioButtonFem);
        intersexo = findViewById(R.id.radioButtonInt);
        prefiroNaoDizer = findViewById(R.id.radioButtonNao);

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);
        textEmail = findViewById(R.id.textEmail);
        textSexo = findViewById(R.id.textSexo);

        Button btn = findViewById(R.id.btCadastrar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Nome = nome.getText().toString();
                String Idade = idade.getText().toString();
                String Email = email.getText().toString();

                if (Nome.isEmpty() || Idade.isEmpty() || Email.isEmpty()){
                    Snackbar.make(view, "Não deixe de preencher todos os campos :)", Snackbar.LENGTH_SHORT).show();
                } else {
                    btSelecionado(view);
                }
            }
        });
    }
    private void btSelecionado(View view) {

        String Nome = nome.getText().toString();
        String Idade = idade.getText().toString();
        String Email = email.getText().toString();

        if(masculino.isChecked()) {
            textNome.setText((CharSequence) Nome);
            textIdade.setText((CharSequence) Idade);
            textEmail.setText((CharSequence) Email);
            textSexo.setText("Sexo: Masculino");
        }else if(feminino.isChecked()) {
            textNome.setText((CharSequence) Nome);
            textIdade.setText((CharSequence) Idade);
            textEmail.setText((CharSequence) Email);
            textSexo.setText("Sexo: Feminino");
        }else if(intersexo.isChecked()) {
            textNome.setText((CharSequence) Nome);
            textIdade.setText((CharSequence) Idade);
            textEmail.setText((CharSequence) Email);
            textSexo.setText("Sexo: Intersexo");
        }else if(prefiroNaoDizer.isChecked()) {
            textNome.setText((CharSequence) Nome);
            textIdade.setText((CharSequence) Idade);
            textEmail.setText((CharSequence) Email);
            textSexo.setText("Sexo: Prefiro não dizer");
        }else{
            Snackbar.make(view, "Lembre de marcar o seu sexo ;)", Snackbar.LENGTH_SHORT).show();
        }
    }
}
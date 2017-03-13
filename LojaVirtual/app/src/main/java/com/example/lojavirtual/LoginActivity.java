package com.example.lojavirtual;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button cadastrar;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cadastrar = (Button) findViewById(R.id.btn_cadastrar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

    }

    public void entrar (View view) {

        EditText usuario = (EditText) findViewById(R.id.edit_usuario);
        EditText senha = (EditText) findViewById(R.id.edit_senha);

        if (usuario.getText().length() == 0) {
            usuario.setError("Usuário Obrigatório");
        } else {
            if (senha.getText().length() == 0) {
                senha.setError("Senha Obrigatória");
            } else {
               // MensagemUtil.addMsg(LoginActivity.this, "Login Realizado com Sucesso!");
                Intent i = new Intent(LoginActivity.this, PrincipalActivity.class);
                startActivity(i);
            }
        }


    }
}

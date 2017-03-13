package com.example.lojavirtual;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.lojavirtual.util.Mask;
import com.example.lojavirtual.util.MensagemUtil;
import com.example.lojavirtual.util.Validate;

import javax.xml.validation.Validator;

public class CadastroActivity extends AppCompatActivity {

    private Button voltar;
    private Button confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        voltar = (Button) findViewById(R.id.btn_voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                finish();
            }
        });

    }

    public void confirmar(View view) {
        final EditText campo_nome = (EditText) findViewById(R.id.campo_nome);
        if (campo_nome.getText().length() == 0) {
            campo_nome.setError("Nome é Obrigatório!");
        }

        final EditText data_nascimento = (EditText) findViewById(R.id.campo_data_nascimento);
        if (data_nascimento.getText().length() == 0) {
            data_nascimento.setError("Data de Nascimento é Obrigatório!");
        }

        final EditText telefone = (EditText) findViewById(R.id.campo_telefone);
        if (telefone.getText().length() == 0) {
            telefone.setError("Telefone é um Campo Obrigatório!");
        }

        final EditText usuario = (EditText) findViewById(R.id.new_usuario);
        if (usuario.getText().length() == 0) {
            usuario.setError("Usuário Obrigatório!");
        }

        final EditText new_senha = (EditText) findViewById(R.id.new_senha);
        if (new_senha.getText().length() == 0) {
            new_senha.setError("Senha é um campo Obrigatório!");
        }
        final EditText new_repitasenha = (EditText) findViewById(R.id.new_repitasenha);
        if (new_repitasenha.getText().length() == 0) {
            new_senha.setError("Repita Senha é um campo Obrigatório!");
        } else {
            if (new_repitasenha == new_senha) {
                //inserir senha no banco
            }else{
                new_repitasenha.setError("As Senhas Devem ser Iguais!");
            }
        }
        final EditText campo_cpf = (EditText) findViewById(R.id.campo_cpf);
        campo_cpf.addTextChangedListener(Mask.insert("###.###.###-##", campo_cpf));

        final EditText campo_email = (EditText) findViewById(R.id.campo_email);

           Validate.validateNotNull(campo_nome, "Preencha o campo nome");
           Validate.validateNotNull(campo_cpf, "Preencha o campo CPF");
            boolean cpf_valido = Validate.validateCPF(campo_cpf.getText().toString());
            if (!cpf_valido) {
               //MensagemUtil.addMsg(CadastroActivity.this, "CPF Invalido!");
               campo_cpf.setError("CPF inválido");
               campo_cpf.setFocusable(true);
               campo_cpf.requestFocus();
            }
            boolean email_valido = Validate.validateEmail(campo_email.getText().toString());
            if (!email_valido) {
               campo_email.setError("Email inválido");
               campo_email.setFocusable(true);
               campo_email.requestFocus();
            }
    }
}

package com.example.plantoterapiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btnRegister =  findViewById(R.id.btnRegistrar);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNewLogin =  findViewById(R.id.etCadastroEmail);
                final String newLogin = etNewLogin.getText().toString();
                if(newLogin.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de login não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etNewPassword =  findViewById(R.id.etCadastroSenha);
                final String newPassword = etNewPassword.getText().toString();
                if(newPassword.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de senha não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etNewPasswordCheck =  findViewById(R.id.etCadastroSenhaConf);
                String newPasswordCheck = etNewPasswordCheck.getText().toString();
                if(newPasswordCheck.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de checagem de senha não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                if(!newPassword.equals(newPasswordCheck)) {
                    Toast.makeText(CadastroActivity.this, "Senha não confere", Toast.LENGTH_LONG).show();
                    return;
                }

                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        HttpRequest httpRequest = new HttpRequest(Config.SERVER_URL_BASE + "cadastro.php", "POST", "UTF-8");
                        httpRequest.addParam("newLogin", newLogin);
                        httpRequest.addParam("newPassword", newPassword);

                        try {
                            InputStream is = httpRequest.execute();
                            String result = Util.inputStream2String(is, "UTF-8");
                            httpRequest.finish();

                            JSONObject jsonObject = new JSONObject(result);
                            final int success = jsonObject.getInt("success");
                            if(success == 1) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(CadastroActivity.this, "Novo usuario registrado com sucesso", Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                });
                            }
                            else {
                                final String error = jsonObject.getString("error");
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(CadastroActivity.this, error, Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        Button btnLoginNewUser = findViewById(R.id.btnLogin);
        btnLoginNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
package com.otaviofr.correioscubagem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editAltura;
    private EditText editLargura;
    private EditText editComprimento;
    private Button btnCalcular;
    private Button btnNovo;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.text_View_Reultado);
        editAltura = findViewById(R.id.edit_altura);
        editLargura = findViewById(R.id.edit_largura);
        editComprimento = findViewById(R.id.edit_comprimento);
        btnCalcular = findViewById(R.id.button_calcular);
        btnNovo = findViewById(R.id.button_novo);

        btnNovo.setOnClickListener(this);
        btnCalcular.setOnClickListener(this);

        this.LimpaValores();
    }


    @Override
    public void onClick(View v) {
        //Botão Calcular
        if (v.getId() == R.id.button_calcular) {
            String valorAltura = editAltura.getText().toString();
            if ("".equals(valorAltura)) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.button_calcular) {
                String valorLargura = editLargura.getText().toString();
                if ("".equals(valorLargura)) {
                    Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.button_calcular) {
                    String valorComprimento = editComprimento.getText().toString();
                    if ("".equals(valorComprimento)) {
                        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    } else if (v.getId() == R.id.button_calcular) {
                        String valorAlt = editAltura.getText().toString();
                        Integer altura = Integer.valueOf(valorAlt);
                        if (altura > 105) {
                            Toast.makeText(this, "Máximo 105 cm", Toast.LENGTH_SHORT).show();
                        } else if (v.getId() == R.id.button_calcular) {
                            String valorLarg = editLargura.getText().toString();
                            Integer largura = Integer.valueOf(valorLarg);
                            if (largura > 105) {
                                Toast.makeText(this, "Máximo 105 cm", Toast.LENGTH_SHORT).show();
                            } else if (v.getId() == R.id.button_calcular) {
                                String valorComp = editComprimento.getText().toString();
                                Integer comprimento = Integer.valueOf(valorComp);
                                if (comprimento > 105) {
                                    Toast.makeText(this, "Máximo 105 cm", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            }
        }
        if (v.getId() == R.id.button_calcular) {
            Calculo();
        }


        //Botão Novo
        if (v.getId() == R.id.button_novo) {
            editAltura.setText("");
            editLargura.setText("");
            editComprimento.setText("");
        }

    }

    private void LimpaValores() {
        textResultado.setText("");
    }

    public void Calculo() {
        String resultadoAlt = editAltura.getText().toString();
        Integer alturaSoma = Integer.valueOf(resultadoAlt);

        String resultadoLarg = editLargura.getText().toString();
        Integer larguraSoma = Integer.valueOf(resultadoLarg);

        String resultadorComp = editComprimento.getText().toString();
        Integer comprimentoSoma = Integer.valueOf(resultadorComp);

        int soma = (alturaSoma + larguraSoma + comprimentoSoma);
        int cubagem = ((alturaSoma * larguraSoma * comprimentoSoma)/6000);

        if(soma > 200){
            textResultado.setText("Soma dos lados maior que 200 cm.");
        }else if(cubagem > 5){
            textResultado.setText("Sua encomenda vai ser cobrada por cubagem!");
        }else{
            textResultado.setText("Sua encomenda não pegou cubagem!");
        }
    }
}

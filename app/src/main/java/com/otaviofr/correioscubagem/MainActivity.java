package com.otaviofr.correioscubagem;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextView textResultado;
    private Button btnNovo;
    private Button btnCalcular;

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
        String valorAltura = editAltura.getText().toString();
        String valorLargura = editLargura.getText().toString();
        String valorComprimento = editComprimento.getText().toString();
        //Botão Calcular
        if (v.getId() == R.id.button_calcular) {
            if (valorAltura.equals("") || valorLargura.equals("") || valorComprimento.equals("")) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                int altura = Integer.parseInt(valorAltura);
                int largura = Integer.parseInt(valorLargura);
                int comprimento = Integer.parseInt(valorComprimento);
                if (altura > 105 || largura > 105 || comprimento > 105) {
                    Toast.makeText(this, "Máximo 105 cm", Toast.LENGTH_SHORT).show();
                } else {
                    Calculo();
                }
            }

        }

        //Botão Novo
        if (v.getId() == R.id.button_novo) {
            editAltura.setText("");
            editLargura.setText("");
            editComprimento.setText("");
            textResultado.setText("");
        }
    }

    private void LimpaValores() {
        textResultado.setText("");
    }

    public void Calculo() {
        String resultadoAlt = editAltura.getText().toString();
        Integer alturaSoma = Integer.parseInt(resultadoAlt);

        String resultadoLarg = editLargura.getText().toString();
        Integer larguraSoma = Integer.parseInt(resultadoLarg);

        String resultadorComp = editComprimento.getText().toString();
        Integer comprimentoSoma = Integer.parseInt(resultadorComp);

        int soma = (alturaSoma + larguraSoma + comprimentoSoma);
        int cubagem = ((alturaSoma * larguraSoma * comprimentoSoma) / 6000);

        if (soma > 200) {
            textResultado.setText("Soma dos lados maior que 200 cm.");
        } else if (cubagem > 5) {
            textResultado.setText("Sua encomenda vai ser cobrada por cubagem!");
        } else {
            textResultado.setText("Sua encomenda não pegou cubagem!");
        }
    }
}

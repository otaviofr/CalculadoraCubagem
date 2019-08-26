package com.otaviofr.correioscubagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editAltura;
    private EditText editLargura;
    private EditText editComprimento;
    private TextView textResultado;
    private TextView mostraPesoCubico;
    private Button btnNovo;
    private Button btnCalcular;
    private Spinner spinner;

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
        mostraPesoCubico = findViewById(R.id.textMostraPesoCubico);

        spinner = findViewById(R.id.spinner_peso);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_pesos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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

                Calculo(altura, largura, comprimento);
            }
        }

        //Botão Novo
        if (v.getId() == R.id.button_novo) {
            editAltura.setText("");
            editLargura.setText("");
            editComprimento.setText("");
            textResultado.setText("");
            mostraPesoCubico.setText("0,00");
            spinner.setSelection(0);
        }
    }

    private void LimpaValores() {
        mostraPesoCubico.setText("0,00");
        textResultado.setText("");
    }

    public void Calculo(Integer alturaSoma, Integer larguraSoma, Integer comprimentoSoma) {
        float soma = (alturaSoma + larguraSoma + comprimentoSoma);
        float cubagem = ((alturaSoma * larguraSoma * comprimentoSoma) / 6000.0f);
        int spinnerPeso = spinner.getSelectedItemPosition();

        if (alturaSoma == 0 || larguraSoma == 0 || comprimentoSoma == 0) {
            Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show();
            textResultado.setText("");
        } else if (alturaSoma < 1) {
            Toast.makeText(this, "Altura mínima 1 cm", Toast.LENGTH_SHORT).show();
            textResultado.setText("");
        } else if (larguraSoma < 10) {
            Toast.makeText(this, "Largura mínima 10 cm", Toast.LENGTH_SHORT).show();
            textResultado.setText("");
        } else if (comprimentoSoma < 15) {
            Toast.makeText(this, "Comprimento mínimo 15 cm", Toast.LENGTH_SHORT).show();
            textResultado.setText("");
        } else if (alturaSoma > 105 || larguraSoma > 105 || comprimentoSoma > 105) {
            Toast.makeText(this, "Máximo 105 cm", Toast.LENGTH_SHORT).show();
        } else if (spinnerPeso == 0) {
            Toast.makeText(this, "Selecione o peso", Toast.LENGTH_SHORT).show();

        } else if (soma > 200) {
            textResultado.setText(getString(R.string.soma_dos_lados));
        } else if (cubagem >= 5 && spinnerPeso < cubagem) {
            textResultado.setText(getString(R.string.pegou_cubagem));
            mostraPesoCubico.setText(String.format("%.2f", (cubagem)));
        } else if (spinnerPeso > cubagem) {
            textResultado.setText(getString(R.string.nao_pegou_cubagem));
            mostraPesoCubico.setText(String.format("%.2f", (cubagem)));
        } else {
            textResultado.setText(getString(R.string.nao_pegou_cubagem));
            mostraPesoCubico.setText(String.format("%.2f",(cubagem)));
        }
    }
}

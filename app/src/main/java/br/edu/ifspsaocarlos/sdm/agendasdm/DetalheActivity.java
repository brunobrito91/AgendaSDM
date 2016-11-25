package br.edu.ifspsaocarlos.sdm.agendasdm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifspsaocarlos.sdm.agendasdm.model.Contato;

public class DetalheActivity extends Activity {
    private Contato contato;
    private EditText etNome;
    private EditText etFone;
    private EditText etEmail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        etNome = (EditText) findViewById(R.id.et_nome);
        etFone = (EditText) findViewById(R.id.et_fone);
        etEmail = (EditText) findViewById(R.id.et_email);
        if (getIntent().hasExtra(AgendaActivity.PARAMETRO_CONTATO)) {
            contato = (Contato) getIntent().getSerializableExtra(AgendaActivity.PARAMETRO_CONTATO);
            etNome.setText(contato.getNome());
            etFone.setText(contato.getFone());
            etEmail.setText(contato.getEmail());
        }        /* Rotinas de abertura de conexão para persistência */
    }

    public void onClick(View v) {
        String nome = etNome.getText().toString();
        String fone = etFone.getText().toString();
        String email = etEmail.getText().toString();
        if (contato == null) {
            contato = new Contato();
            contato.setId(Contato.ID_INVALIDO);
            contato.setNome(nome);
            contato.setFone(fone);
            contato.setEmail(email);            /* Rotinas de salvamento de novo contato */
            Toast.makeText(this, getString(R.string.mensagem_incluido), Toast.LENGTH_SHORT).show();
        } else {
            contato.setNome(nome);
            contato.setFone(fone);
            contato.setEmail(email);            /* Rotina de atualização de contato existente */
            Toast.makeText(this, getString(R.string.mensagem_alterado), Toast.LENGTH_SHORT).show();
        }        /* Retornando para a tela anterior */
        Intent intentResultado = new Intent();
        intentResultado.putExtra(AgendaActivity.PARAMETRO_CONTATO, contato);
        setResult(RESULT_OK, intentResultado);
        finish();
    }
} 
package br.edu.ifspsaocarlos.sdm.agendasdm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifspsaocarlos.sdm.agendasdm.model.Contato;

/**
 * Created by BrunoBrito91 on 24/11/2016.
 */

public class ContatoArrayAdapter extends ArrayAdapter<Contato> {
    private LayoutInflater inflater;

    public ContatoArrayAdapter(Activity tela, List<Contato> contatos) {
        super(tela, android.R.layout.simple_list_item_1, contatos);
        inflater = tela.getLayoutInflater();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
        }
        Contato contato = getItem(position);
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(contato.getNome());
        return convertView;
    }
}
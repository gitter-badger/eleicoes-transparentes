package br.ufba.mata62.eleicoestransparentes.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import br.ufba.mata62.eleicoestransparentes.R;
import br.ufba.mata62.eleicoestransparentes.persistance.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.Comite;
import br.ufba.mata62.eleicoestransparentes.persistance.Eleicao;
import br.ufba.mata62.eleicoestransparentes.persistance.Partido;

public class VisualizarPrestacaoDeContas extends FragmentActivity{
	
	public void visualizaTransacoes(Candidato candidato, Eleicao eleicao) {

	}

	public void visualizaTransacoes(Partido partido, Eleicao eleicao) {

	}

	public void visualizaTransacoes(Comite comite, Eleicao eleicao) {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizar_prestacao_contas);
	}

}
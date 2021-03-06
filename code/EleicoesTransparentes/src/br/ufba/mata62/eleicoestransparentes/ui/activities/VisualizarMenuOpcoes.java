package br.ufba.mata62.eleicoestransparentes.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import br.ufba.mata62.eleicoestransparentes.adapters.MenuAdapter;

public class VisualizarMenuOpcoes extends FragmentActivity{

	private int[] menuItens = { R.string.mi_visualizar_prestacao_contas,
			R.string.mi_visualizar_ranking_maiores_doadores_juridico,
			R.string.mi_visualizar_ranking_maiores_doadores_fisica,
			R.string.mi_visualizar_lista_candidatos};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loadComponents();
	}

	private void loadComponents() {
		ListView menu = (ListView) findViewById(R.id.menu);
		BaseAdapter adapter = new MenuAdapter(VisualizarMenuOpcoes.this, menuItens);
		menu.setAdapter(adapter);
		
		menu.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position,long id) {
				switch (position) {
				case 0:
					startActivity(new Intent(VisualizarMenuOpcoes.this,VisualizarPrestacaoDeContas.class));
					break;
				case 1:
					startActivity(new Intent(VisualizarMenuOpcoes.this,VisualizarRankingMaioresDoadoresJuridico.class));
					break;
					
				case 2:
					startActivity(new Intent(VisualizarMenuOpcoes.this,VisualizarRankingMaioresDoadoresFisico.class));
					break;

				case 3:
					startActivity(new Intent(VisualizarMenuOpcoes.this,VisualizarListaCandidatosBens.class));
					break;
				default:
					break;
				}		
			}
		});
	}

}
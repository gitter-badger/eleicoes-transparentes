package business;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.*;

public abstract class GraficoBuilder {

	public GraficoFinal graficoFinal;
	
	public abstract void buildValores() throws SQLException;

	public abstract void buildTipo();
	
	public abstract void buildNome();
}

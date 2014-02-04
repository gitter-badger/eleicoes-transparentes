package br.ufba.mata62.eleicoestransparentes.connection;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;

import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Bem;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Candidato;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Pessoa;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.SetorEconomico;
import br.ufba.mata62.eleicoestransparentes.persistance.database.beans.Transacao;

import com.google.gson.reflect.TypeToken;


public class EleicoesSOAP {

	public static final String METHOD_APP_PATH					= "consultaApplicationPath";
	
	public static final String METHOD_CREATE_TABLES				= "createTables";
	
	public static final String METHOD_SETORES					= "consultaSetoresEconomico";
	public static final String METHOD_CANDIDATOS				= "consultaCandidatos";
	public static final String METHOD_PARSER					= "parserDadosTSE";
	public static final String METHOD_PREST_CONTAS_PARTIDO		= "consultaTransacaoPartido";
	private static final String METHOD_PREST_CONTAS_CANDIDATOS 	= "consultaTransacaoCandidatos";
	public static final String METHOD_RANKING_MAIORES_DOADORES 	= "rankingMaioresDoadores";
	public static final String METHOD_BENS						= "consultaBens";
	public static final String METHOD_DOACOES				= "consultaDoacoes";
	
	private static final String AUTH_KEY 						= "f877fbd3d7c0d0313d3243ff0edcc73d";

	

	
	
	private SoapRequest soap;
	public EleicoesSOAP() {
		 this(false);
	}
	
	public EleicoesSOAP(boolean localhost){
		if(localhost){
			soap = new SoapRequest(SoapRequest.URL_DEBUG,SoapRequest.NAMESPACE_DEBUG);
		}else{
			soap = new SoapRequest();
		}
	}
	
	public List<SetorEconomico> consultaSetoresEconomico(){
		
		Type t = new TypeToken<List<SetorEconomico>>(){}.getType();
		List<SetorEconomico> setores = soap.executeSoapRequest(EleicoesSOAP.METHOD_SETORES, t);
		
		return setores;
	}

	public float consultaTransacaoPartido(String sigla,String UF) {
		
		Type t = new TypeToken<List<Transacao>>(){}.getType();
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("sigla", sigla));
		params.add(createParam("UF", UF));
		float valor = soap.executeSoapRequest(EleicoesSOAP.METHOD_PREST_CONTAS_PARTIDO, t,params);
		
		return valor;
	}
	
	public float consultaTransacaoCandidato(String sigla,String UF) {
		
		Type t = new TypeToken<Float>(){}.getType();
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("sigla", sigla));
		params.add(createParam("UF", UF));
		float valor = soap.executeSoapRequest(EleicoesSOAP.METHOD_PREST_CONTAS_CANDIDATOS, t,params);
		
		return valor;
	}
	
	public List<Pessoa> rankingMaioresDoadores(String sigla,String UF) {
		Type t = new TypeToken<List<Transacao>>(){}.getType();
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("sigla", sigla));
		params.add(createParam("UF", UF));
		List<Pessoa> doadores = soap.executeSoapRequest(EleicoesSOAP.METHOD_RANKING_MAIORES_DOADORES, t,params);
		return doadores;
	}
	
	
	
	public List<Candidato> consultaCandidatos() {
		
		Type t = new TypeToken<List<Candidato>>(){}.getType();
		List<Candidato> candidatos = soap.executeSoapRequest(EleicoesSOAP.METHOD_CANDIDATOS, t);
		
		return candidatos;
	}
	
	public List<Candidato> consultaCandidatos(String sigla,String UF) {
		Type t = new TypeToken<List<Candidato>>(){}.getType();
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("sigla", sigla));
		params.add(createParam("UF", UF));
		List<Candidato> candidatos = soap.executeSoapRequest(EleicoesSOAP.METHOD_CANDIDATOS, t,params);
		
		return candidatos;
	}
	
	public List<Bem> consultaBens(String cpf) {
		Type t = new TypeToken<List<Bem>>(){}.getType();
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("cpf", cpf));
		List<Bem> bens = soap.executeSoapRequest(EleicoesSOAP.METHOD_BENS, t,params);
		
		return bens;
	}
	
	/**
	 * 
	 * @param sigla - Sigla do Partido
	 * @param UF - Unidade Federada
	 * @param tipo F - Física , J - Jurídica
	 * @return Valor 
	 */
	public float consultaDoacoes(String sigla, String UF, String tipo ) {
		Type t = new TypeToken<List<Transacao>>(){}.getType();
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("sigla", sigla));
		params.add(createParam("uf", UF));
		params.add(createParam("tipo", tipo));
		float valor = soap.executeSoapRequest(EleicoesSOAP.METHOD_BENS, t,params);
		
		return valor;
	}
	
	/**
	 * 
	 * @param sigla - Sigla do Partido
	 * @param UF - Unidade Federada
	 * @param cpf - cpf do candidato
	 * @param tipo F - Física , J - Jurídica
	 * @return Valor 
	 */
	public float consultaDoacoes(String sigla, String UF, String cpf, String tipo) {
		Type t = new TypeToken<List<Transacao>>(){}.getType();
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("sigla", sigla));
		params.add(createParam("uf", UF));
		params.add(createParam("cpf", cpf));
		params.add(createParam("tipo", tipo));
		float valor = soap.executeSoapRequest(EleicoesSOAP.METHOD_BENS, t,params);
		
		return valor;
	}

	public String consultaApplicationPath(){
		
		Type t = new TypeToken<String>(){}.getType();
		String result = soap.executeSoapRequest(EleicoesSOAP.METHOD_APP_PATH, t);
		
		return result;
	}
	
	public String createTables(){
		Type t = new TypeToken<String>(){}.getType();
		
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("chaveSeguranca", AUTH_KEY));
		
		String result = soap.executeSoapRequest(EleicoesSOAP.METHOD_CREATE_TABLES, t, params);
		
		return result;
	}
	
	public String parserDados(){
		Type t = new TypeToken<String>(){}.getType();
		
		List<PropertyInfo> params = new ArrayList<PropertyInfo>();
		params.add(createParam("chaveSeguranca", AUTH_KEY));
		
		String result = soap.executeSoapRequest(EleicoesSOAP.METHOD_PARSER, t, params);
		
		return result;
	}
	
	private static PropertyInfo createParam(String name, String value) {
		return createParam(name, value, String.class);
	}
	
	private static <T> PropertyInfo createParam(String name, Object value, Class<T> type) {
		PropertyInfo chaveSegurancaProperty = new PropertyInfo();
		chaveSegurancaProperty.setName(name);
		chaveSegurancaProperty.setValue(value);
		chaveSegurancaProperty.setType(type);
		return chaveSegurancaProperty;
	}
}

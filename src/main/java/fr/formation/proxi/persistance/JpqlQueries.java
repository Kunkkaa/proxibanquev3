package fr.formation.proxi.persistance;


/**
 * Classe contenant sous forme de constantes l'ensemble des requetes necessaires aux manipulations de la base de donnees.
 * 
 * @author Adminl
 *
 */
public class JpqlQueries {
	
	public static final String SELECT_ALL_CLIENT = "SELECT c FROM Client c";
	public static final String SELECT_ALL_ACCOUNT = "SELECT a FROM Account a";
	public static final String SELECT_ALL_ADVISOR = "SELECT a FROM Advisor a";
	public static final String SELECT_ADVISOR_BY_NAME = "SELECT a FROM Advisor a WHERE a.username=:username";
	public static final String SELECT_ALL_BANKCARD = "SELECT bc FROM BankCard bc";
}

package fr.formation.proxi.persistance;

import java.util.List;

/**
 * Définition d'une interface comportant les 4 méthodes élémentaires de 
 * manipulation de données CRUD 
 * + readALL.
 * @param <T> classe qui représente le type de données manipulé par le DAO.
 */
public interface Dao<T> {
	
	
	
	/**
	 * Crée une nouvelle entité de base de données.
	 * 
	 * @param entity l'entité à créer 
	 * @return T l'entité avec son identifiant rempli
	 */
	public T create(T entity);
	
	
	
	
	/**
	 * Lit lesinformations d'une entité de BDD
	 * 
	 * @param id l'identifiant d'une entité en base de données
	 * @return T l'entité construite à partir des informations récupérées
	 * 
	 */
	public T read(Integer id);
	
	
	
	
	/**
	 * Récupère toutes les entités (lignes) d'une table
	 * 
	 * @return List<T> la liste de toutes les entités lues.
	 */
	public List<T> readall();
	
	
	
	/**
	 * met à jour l'entité donné dans la BDD
	 *  
	 * @param entity l'entité à mettre à jour avec les nouvelles informations
	 * @return l'entité mise à jour
	 */
	public T update(T entity);
	
	
	
	/**
	 * 
	 * @param entity l'entité à supprimer 
	 * @return si l'entité a été supprimé renvoie vrai else renvoi faux
	 */
	public boolean delete(Integer id);
	
	
}

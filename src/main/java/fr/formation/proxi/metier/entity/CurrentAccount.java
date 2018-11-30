package fr.formation.proxi.metier.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// Valeur de la colonne 'savings' de la table account permettant d'identifier un compte comme étant un compte courant.
@DiscriminatorValue("CURRENT")
public class CurrentAccount extends Account {

}

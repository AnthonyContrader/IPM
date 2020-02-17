package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Crea costruttore con tutti gli argomenti
@AllArgsConstructor

// Crea costruttore vuoto
@NoArgsConstructor

// Di Lombok, permette di generare i metodi set e get, il toString e l'equals
@Data

// Di Hibernate, effettua la creazione della tabella nel database indicato sul file application.properties
@Entity

public class Environment{
// Permette di generare la Primary Key
	@Id
	
	// Effettua l'Auto Increment del valore della Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Genera le colonne che apparterranno alla tabella generata e gli attribuisce il valore di Unique
	@Column(unique = true)
	private String name;
	
	private String description;
}
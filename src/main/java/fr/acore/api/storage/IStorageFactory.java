package fr.acore.api.storage;

import fr.acore.api.storage.database.IDatabase;
import fr.acore.api.storage.exception.DBExistsException;
import fr.acore.api.storage.exception.DBNotFoundException;
import fr.acore.api.storage.factory.IDataFactory;

import java.util.List;


public interface IStorageFactory {
	
	/*
	 * 
	 * Chargement et sauvegarde
	 * 
	 */
	
	public void load();
	public void save();
	
	/*
	 * 
	 * Gestion des databases
	 * 
	 */
	
	public void addDatabase(IDatabase<?> db) throws DBExistsException;
	
	public List<IDatabase<?>> getDatabases();
	public IDatabase<?> getDatabase(String name) throws DBNotFoundException;
	
	public IDatabase<?> getDefaultDatabase();
	public void setDefaultDatabase(String name) throws DBNotFoundException;

	/*
	 * 
	 * 
	 * Gestion de la population des tables
	 * 
	 */
	
	public List<IDataFactory<?>> getDataFactories();
	public void addDataFactory(IDataFactory<?> dataFactory);
	public void removeDataFactory(IDataFactory<?> dataFactory);
	
}

package fr.acore.api.config.factory;

import fr.acore.api.config.IConfiguration;

import java.util.List;

/*

Gestionnaires des instances de ISetupable

 */

public interface IConfigurationFactory<T extends IConfiguration> {

	//permet de recuperer tout les config
	public List<T> getConfigurations();
	//ajout d'une config
	public void addConfiguration(T configuration);
	//suppresion d'une config
	public void removeConfiguration(T configuration);
	//suppresion de toute les configs
	public void removeAllConfiguration();

	//re charge toute les configs
	public void reload();

}

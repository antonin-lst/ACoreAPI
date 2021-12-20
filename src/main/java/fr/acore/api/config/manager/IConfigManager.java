package fr.acore.api.config.manager;

import fr.acore.api.config.ISetupable;

import java.util.List;
import java.util.Map;

/*

Gestionnaires des instances de ISetupable

 */

public interface IConfigManager{
	//permet de recuperer tout les config
	public List<ISetupable> getSetupables();
	//ajout d'une config
	public void addSetupable(ISetupable setupable);
	//suppresion d'une config
	public void removeSetupable(ISetupable setupable);
	//suppresion de toute les configs
	public void removeAllSetupable();

	//re charge toute les configs
	public void reload();

}

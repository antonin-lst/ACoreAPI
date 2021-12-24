package fr.acore.api.parser.conf;

import fr.acore.api.copy.ICopyExecutor;
import fr.acore.api.copy.ICopyProcess;
import fr.acore.api.parser.exception.LoadConfigurationException;
import fr.acore.api.parser.exception.SaveConfigurationException;
import fr.acore.api.parser.node.INode;

/*

Fichier de configuration parser

T = flux d'entree
V = flux de sortie
 */

public interface IParsedConfiguration<T, U extends ICopyProcess<T>> extends ICopyExecutor<T, U> {

    //stream parse
    public T getStream();
    //utilisée quand le fichier et chargé
    public void load() throws LoadConfigurationException;
    //utilisée quand aucun fichier n'est chargé
    public void load(T stream) throws LoadConfigurationException;
    //sauvegarde l'etat de l'object
    public void save() throws SaveConfigurationException;

    //getter des nodes par leur chemin d'access par example rsection1.encsection.node1
    public INode getNodeByRoute(String route);
}

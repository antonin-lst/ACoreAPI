package fr.acore.api.web.executor;

import fr.acore.api.web.request.IRequest;

    /*
        Interface Exécuteur des requêtes de l'API Web
    */

public interface IRequestExecutor {

    //gestion des débuts d'url récurents
    public String getRoot();
    public void setRoot(String root);

    //supoport de l'asynchrone
    public boolean isSupportAsync();
    public void setSupportAsync(boolean supportAsync);

    //exéction d'une requête
    public void execute(IRequest request);


}
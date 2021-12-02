package fr.acore.api.web.callback;

import java.io.InputStream;

    /*

    Interface du CallBack d'une Requête de l'API Web

     */

public interface IWebCallBack {

    //CallBack pour les requête Web (HTTP/HTTPS)
    public void callBack(boolean successful, InputStream response, Exception exception, int responseCode);



}

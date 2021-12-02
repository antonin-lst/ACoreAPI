package fr.acore.api.web.request;

import fr.acore.api.web.callback.IWebCallBack;
import fr.acore.api.web.exception.AsyncRequestNotSupportedException;
import fr.acore.api.web.executor.IRequestExecutor;
import fr.acore.api.web.utils.WebMethod;

import java.net.HttpURLConnection;
import java.util.Map;

    /*

    Interface d'une requête Web (Http,Https)

     */

public interface IRequest {

    //gestion de l'url de la requête
    public String getUrl();
    public String getShortUrl();
    public void setShortUrl(String url);

    //gestion du CallBack
    public IWebCallBack getCallBack();
    public void setCallBack(IWebCallBack callBack);

    //gestion de l'executeur de la requête
    public IRequestExecutor getExecutor();

    //gestion de l'asynchrone
    public boolean isAsync();
    public void setAsync(boolean async) throws AsyncRequestNotSupportedException;

    //gestion de la connection HTTP
    public HttpURLConnection getConnection();
    public void setConnection(HttpURLConnection httpURLConnection);

    //gestion du la methode de la requete
    public WebMethod getWebMethod();
    public void setWebMethod(WebMethod webMethod);

    //gestion des requestProperty
    public Map<String, String> getProperties();
    public void addProperty(String key, String value);

    //execution de la requête
    public void execute();


}

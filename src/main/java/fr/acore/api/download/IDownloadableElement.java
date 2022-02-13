package fr.acore.api.download;

import java.nio.file.Path;

public interface IDownloadableElement {

    //pour check la validiter du fichier dl
    public String getSha1();
    //taille du fichier dl
    public int getSize();
    //emplacement du fichier dl
    public Path getPath();

    public void onStartDownload();
    public void onEndDownload();
    public void onThrowDownload(Exception exception);

    public default boolean checkSha1(){
        return true;
    }
}

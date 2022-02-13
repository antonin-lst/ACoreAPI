package fr.acore.api.download;

import java.util.List;

public interface IDownloader {

    public List<IDownloadableElement> getDownloadableElements();
    public void setDownloadableElements(List<IDownloadableElement> downloadableElements);

    public void start();
    public void stop();
    public boolean isRunning();
    public int getIndex();
    public boolean checkSha1();
}

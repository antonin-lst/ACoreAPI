package fr.acore.api.github;

public interface IRepository {

    //nom du repo
    public String getName();
    public void setName(String name);
    //access status du repo
    public boolean isPrivate();
    public void setPrivate(boolean pv);
}

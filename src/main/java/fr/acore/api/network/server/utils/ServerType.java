package fr.acore.api.network.server.utils;

public enum ServerType {

	/*

	Enumeration des types de serveur installable

	--ajouter la gestion des versions de spigot a installer

	 */

	//PROXY
	PROXY("https://ci.md-5.net/job/BungeeCord/lastSuccessfulBuild/artifact/bootstrap/target/BungeeCord.jar", "BungeeCord.jar", "ACoreBungeeCordAPI"),
	//SERVEUR DE JEU
	SPIGOT("https://cdn.getbukkit.org/spigot/spigot-1.8.8-R0.1-SNAPSHOT-latest.jar", "Spigot-1.8.8.jar", "ACoreSpigotAPI");

	//gestion du lien de téléchargement
	private String dlLink;
	public String getDlLink() { return this.dlLink;}
	//gestion du nom du jar
	private String jarName;
	public String getJarName() { return this.jarName;}
	//gestion du nom de l'API a installer sur le serveur en fonction de son type (Bungee ou Spigot)
	private String apiName;
	public String getApiName() {
		return this.apiName;
	}

	ServerType(String dlLink, String jarName, String apiName){
		this.dlLink = dlLink;
		this.jarName = jarName;
		this.apiName = apiName;
	}

}

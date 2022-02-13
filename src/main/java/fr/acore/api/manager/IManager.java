package fr.acore.api.manager;


import fr.acore.api.project.IProject;

public interface IManager<T extends IProject> {

	public T getProject();
	
}

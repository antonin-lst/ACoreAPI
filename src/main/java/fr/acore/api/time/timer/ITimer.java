package fr.acore.api.time.timer;

import fr.acore.api.time.TimeHelper;

	/*

	Interface d'un timer

	 */

public interface ITimer extends TimeHelper {


	//CurrentTimeMillis du start du timer
	public long getCurrent();
	public void setCurrent(long current);
	//delay du timer
	public long getDelay();
	public void setDelay(long delay);
	//gestion du temps restant
	public long getRemainingTime();
	public String getFormatedRemainingTime();
	//gestion de la fin du timer
	public boolean isFinish();

}
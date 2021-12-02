package fr.acore.api.time.utils;

import java.util.concurrent.TimeUnit;

	/*

	Gestion du temps

	 */

public interface TimeHelper {

	/*

	Parser simplifier pour le temps

	 */

	//transforme des ms en temps avec un format simple
	public default String timeToStringFromMs(long ms) {
		return timeToStringFromSecondes(ms / 1000);
	}
	//transforme des sec en temps avec un format simple
	public default String timeToStringFromSecondes(long secondes) {
		StringBuilder builder = new StringBuilder("");

		int years = getYears(secondes);
		if(years > 0){
			builder.append(years).append("y ");
			secondes -= years * 365 * 86400;
		}

		int months = getMonths(secondes);
		if(months > 0){
			builder.append(months).append("M ");
			secondes -= months * 30 * 86400;
		}

		int weeks = getWeeks(secondes);
		if(weeks > 0) {
			builder.append(weeks).append("w ");
			secondes -= weeks * 86400 * 7;
		}
		
		int days = getDays(secondes);
		if(days > 0) {
			builder.append(days).append("d ");
			secondes -= days * 86400;
		}
		
		int hours = getHours(secondes);
		if(hours > 0) {
			builder.append(hours).append("h ");
			secondes -= hours * 3600;
		}
		
		int minutes = getMinutes(secondes);
		if(minutes > 0) {
			builder.append(minutes).append("m ");
			secondes -= minutes * 60;
		}
		
		if(secondes > 0) {
			builder.append(secondes).append("s");
		}
		return builder.toString();
	}


	/*

	gestion des convertion des secondes vers min,heur,jour,semaine,mois,année

	 */

	public default int getMinutes(long secondes) {
		return (int) TimeUnit.SECONDS.toMinutes(secondes);
	}
	
	public default int getHours(long secondes) {
		return (int) TimeUnit.SECONDS.toHours(secondes);
	}
	
	public default int getDays(long secondes) {
		return (int) TimeUnit.SECONDS.toDays(secondes);
	}
	
	public default int getWeeks(long secondes) {
		return (int) TimeUnit.SECONDS.toDays(secondes) / 7;
	}

	public default int getMonths(long secondes) {
		return (int) TimeUnit.SECONDS.toDays(secondes) / 30;
	}
	
	public default int getYears(long secondes) {
		return (int) TimeUnit.SECONDS.toDays(secondes) / 365;
	}
}

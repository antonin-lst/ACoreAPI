package fr.acore.api.web.exception;

	/*

	Gestion de l'erreur du passage en Asynchrone non supportée par l'Exécuteur

	 */

public class AsyncRequestNotSupportedException extends Exception{

	private static final long serialVersionUID = -1154184023143635343L;

	@Override
	public String getMessage() {
		return "Async HTTP(S) is not supported";
	}

}

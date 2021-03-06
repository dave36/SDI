package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CerrarSesionAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		
		// A completar ...
		HttpSession session = request.getSession(false);
		if(session==null){
			resultado = "FRACASO";
		}
		else{
			session.invalidate();
		}
		
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}

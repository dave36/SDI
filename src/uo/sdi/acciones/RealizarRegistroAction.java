package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;

public class RealizarRegistroAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		User user = new User();
		
		user.setEmail(request.getParameter("email"));
		user.setIsAdmin(false);
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		user.setStatus(UserStatus.ENABLED);
		
		String passwordConfirmacion = request.getParameter("password-confirmacion");
		if(passwordConfirmacion == null ||
				!passwordConfirmacion.equals(user.getPassword())){
			request.setAttribute("error", "Password no coincide");
			resultado = "FRACASO";
		}
		else{
			try{
				UserService us = Services.getUserService();
				us.registerUser(user);
			}
			catch(BusinessException e){
				request.setAttribute("error", e.getMessage());
				resultado = "FRACASO";
			}
		}
		
		return resultado;
	}

}

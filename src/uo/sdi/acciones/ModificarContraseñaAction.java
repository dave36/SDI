package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.dto.util.Cloner;

public class ModificarContraseñaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		String oldPass=request.getParameter("oldPass");
		String newPass=request.getParameter("newPass");
		String newPass2=request.getParameter("newPass2");
		
		HttpSession session=request.getSession();
		User user=((User)session.getAttribute("user"));
		User userClone=Cloner.clone(user);
		
		if(!user.getPassword().equals(oldPass)){
			return "FRACASO";
		}
		if(!newPass.equals(newPass2)){
			return "FRACASO";
		}
		userClone.setPassword(newPass);
		try {
			Services.getUserService().updateUserDetails(userClone);
			session.setAttribute("user", userClone);
		} catch (BusinessException e) {
			return "FRACASO";
		}
		
		return resultado;
	}

}

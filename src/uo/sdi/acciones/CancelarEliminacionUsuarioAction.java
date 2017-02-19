package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;

public class CancelarEliminacionUsuarioAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		List<User> users;
		try {
			users = Services.getAdminService().findAllUsers();
		} catch (BusinessException e) {
			return "FRACASO";
		}
		request.setAttribute("listaUsuarios", users);
		return resultado;
	}

}

package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;

public class ListarUsuariosAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		List<User> usuarios = null;
		
		try{
			AdminService adminService = Services.getAdminService();
			usuarios = adminService.findAllUsers();
			request.setAttribute("listaUsuarios", usuarios);
			Log.debug("Obtenida lista de usuarios conteniendo [%d] usuarios", 
					usuarios.size());
		}
		catch(BusinessException b){
			Log.debug("Algo ha ocurrido obteniendo lista de usuarios: %s",
					b.getMessage());
			resultado="FRACASO";
		}
		
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
}

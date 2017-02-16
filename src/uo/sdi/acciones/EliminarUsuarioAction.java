package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;

public class EliminarUsuarioAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		String idStr = request.getParameter("idUsuario");
		Long id = null;
		if(idStr!=null){
			try{
				id = Long.parseLong(idStr);
			}
			catch(NumberFormatException e){};
		}
		if(id==null){
			request.setAttribute("mensaje", "El id del usuario no se pasó o era null");
			resultado = "FRACASO";
		}
		
		AdminService adminService = Services.getAdminService();
		try{
			adminService.deepDeleteUser(id);
			List<User> usuarios = adminService.findAllUsers();
			request.setAttribute("listaUsuarios", usuarios);
		}
		catch(BusinessException b){
			Log.debug("Error al eliminar al usuario con id [%d]",
					id);
			resultado = "FRACASO";
		}
		
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
}

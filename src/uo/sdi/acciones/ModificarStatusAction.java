package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.AdminService;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;

public class ModificarStatusAction implements Accion {

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
		try {
			User user = adminService.findUserById(id);
			if(user.getStatus() == UserStatus.ENABLED){
				adminService.disableUser(id);
			}
			else{
				adminService.enableUser(id);
			}
			List<User> usuarios = adminService.findAllUsers();
			request.setAttribute("listaUsuarios", usuarios);
			resultado ="EXITO";
		} catch (BusinessException e) {
			Log.debug("Error al modificar el status del usuario");
			resultado = "FRACASO";
		}
		return resultado;
	}

}

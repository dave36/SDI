package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.User;

public class GestionarCategoriasAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		User user = (User)request.getSession().getAttribute("user");
		
		try {
			List<Category> categorias = Services.getTaskService()
										.findCategoriesByUserId(user.getId());
			request.setAttribute("categorias", categorias);
		} catch (BusinessException e) {
			resultado = "FRACASO";
			Log.debug("Error al obtener las categorias del usuario con id [%d]", user.getId());
		}
		return resultado;
	}

}

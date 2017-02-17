package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.User;

public class AñadirCategoriaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		User user = (User)request.getSession().getAttribute("user");
		String nombre = request.getParameter("name");
		Category categoria = new Category();
		
		categoria.setName(nombre);
		if(nombre==null || nombre.equals("")){
			return "FRACASO";
		}
		categoria.setUserId(user.getId());
		
		try {
			Services.getTaskService().createCategory(categoria);
			
			List<Category> categorias = Services.getTaskService()
					.findCategoriesByUserId(user.getId());
			request.setAttribute("categorias", categorias);
		} catch (BusinessException e) {
			resultado = "FRACASO";
			Log.debug("Error al crear categoria para el usuario con id [%d]",
					user.getId());
		}
		
		return resultado;
	}

}

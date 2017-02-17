package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.User;

public class ModificarCategoriaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		Long id =Long.parseLong(request.getParameter("id"));
		
		try {
			Category categoria = Services.getTaskService().findCategoryById(id);
			
			String nombre = request.getParameter("name");
			if(nombre==null || nombre.equals("")){
				return "FRACASO";
			}
			categoria.setName(nombre);
			Services.getTaskService().updateCategory(categoria);
			
			User user = (User)request.getSession().getAttribute("user");
			List<Category> categorias = Services.getTaskService()
					.findCategoriesByUserId(user.getId());
			request.setAttribute("categorias", categorias);
		} catch (BusinessException e) {
			resultado = "FRACASO";
			Log.debug("Error al modificar la categoria con id [%d]", id);
		}
		return resultado;
	}

}

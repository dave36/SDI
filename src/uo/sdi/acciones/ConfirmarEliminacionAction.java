package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.User;

public class ConfirmarEliminacionAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		Long id = Long.parseLong(request.getParameter("idCat"));
		try {			
			Services.getTaskService().deleteCategory(id);
			
			User user = (User)request.getSession().getAttribute("user");
			List<Category> categorias = Services.getTaskService()
					.findCategoriesByUserId(user.getId());
			request.setAttribute("categorias", categorias);
		} catch (BusinessException e) {
			resultado = "FRACASO";
		}
		return resultado;
	}

}

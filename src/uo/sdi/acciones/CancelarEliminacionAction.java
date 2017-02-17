package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.User;

public class CancelarEliminacionAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		User user = (User)request.getSession().getAttribute("user");
		List<Category> categorias;
		try {
			categorias = Services.getTaskService()
					.findCategoriesByUserId(user.getId());
		} catch (BusinessException e) {
			return "FRACASO";
		}
		request.setAttribute("categorias", categorias);
		return resultado;
	}

}

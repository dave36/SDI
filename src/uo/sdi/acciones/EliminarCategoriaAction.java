package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;

public class EliminarCategoriaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		String idStr = request.getParameter("idCategoria");
		Long id = null;
		if(idStr!=null){
			try{
				id = Long.parseLong(idStr);
			}
			catch(NumberFormatException e){};
		}
		if(id==null){
			request.setAttribute("mensaje", "El id de la categoria no se pasó o era null");
			return "FRACASO";
		}
		try {
			Category categoria = Services.getTaskService().findCategoryById(id);
			request.setAttribute("categoria", categoria);
		} catch (BusinessException e) {
			return "FRACASO";
		}
		
		return resultado;
	}

}

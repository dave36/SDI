package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;

public class AñadidoDeTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Long id = null;
		String StrId = request.getParameter("idC");
		
		if(StrId != null){
			try {
				id = Long.parseLong(StrId);
			}
			catch (NumberFormatException e) {};
		}
		
		if(id == null) {
			request.setAttribute("mensaje", "El id de la categoria no se pasó o era null");
			Log.debug("Valor del id"+id);
			return "FRACASO";
		}
		
		Category categoria;
		try {
			categoria = Services.getTaskService().findCategoryById(id);
			request.setAttribute("categoria", categoria);
		} catch (BusinessException e) {
			return "FRACASO";
		}
		
		
		return "EXITO";
	}

}

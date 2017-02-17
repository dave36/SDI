package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;

public class ModificacionDeTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Long id = null;
		String StrId = request.getParameter("idTarea");
		
		if(StrId != null){
			try {
				id = Long.parseLong(StrId);
			}
			catch (NumberFormatException e) {};
		}
		if(id == null) {
			request.setAttribute("mensaje", "El id de la tarea no se pasó o era null");
			return  "FRACASO";
		}
		
		Task tarea;
		try {
			tarea = Services.getTaskService().findTaskById(id);
			request.setAttribute("tarea", tarea);
		} catch (BusinessException e) {
			return "FRACASO";
		}
		
		
		return "EXITO";
	}

}

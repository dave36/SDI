package uo.sdi.acciones;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;


public class ModificarTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado = "EXITO";
		
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
			resultado = "FRACASO";
		}
		
		Task task = null;
		try {
			task = Services.getTaskService().findTaskById(id);
			task.setTitle(request.getParameter("title"));
			task.setComments(request.getParameter("comments"));
			Services.getTaskService().updateTask(task);
		} catch (BusinessException e1) {
			request.setAttribute("error", e1.getMessage());
			resultado = "FRACASO";
		}
		
		
//		DateFormat formatter1 = new SimpleDateFormat("DD/mm/yyyy");
//		try {
//			task.setPlanned((Date)formatter1.parse(request.getParameter("planned")));
//		} catch (ParseException e1) {
//			Log.debug("Fecha incorrecta");
//		}
		
		resultado = "EXITO";
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}

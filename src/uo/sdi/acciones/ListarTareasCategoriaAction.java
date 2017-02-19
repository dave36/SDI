package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;


public class ListarTareasCategoriaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String respuesta = "EXITO";
		
		String idStr = request.getParameter("id");
		Long id = null;
		if(idStr!=null){
			try{
				id = Long.parseLong(idStr);
			}
			catch(NumberFormatException e){};
		}
		if(id==null){
			request.setAttribute("mensaje", "El id de la categoría no se pasó o era null");
			respuesta = "FRACASO";
		}
		
		TaskService taskService = Services.getTaskService();
		try {
			List<Task> tasks = taskService.findTasksByCategoryId(id);
			request.setAttribute("tasks", tasks);
			request.setAttribute("idCategoria", id);
		} catch (BusinessException e) {
			request.setAttribute("mensaje", e.getMessage());
			respuesta = "FRACASO";
		}
		
		return respuesta;
	}

}

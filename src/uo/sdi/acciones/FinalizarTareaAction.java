package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;

public class FinalizarTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		Long id = null;
		String StrId = request.getParameter("idTarea");
		
		if(StrId!=null){
			try{
				id = Long.parseLong(StrId);
			}
			catch(NumberFormatException e){};
		}
		if(id==null){
			request.setAttribute("mensaje", "El id de la tarea no se pasó o era null");
			resultado = "FRACASO";
		}
		
		TaskService taskService = Services.getTaskService();
		try {
			taskService.markTaskAsFinished(id);
			User user = (User)request.getSession().getAttribute("user");
			List<Task> tasks = taskService.findTodayTasksByUserId(user.getId());
			request.setAttribute("tasks", tasks);
			resultado = "EXITO";
		} catch (BusinessException e) {
			request.setAttribute("mensaje", e.getMessage());
			resultado = "FRACASO";
		}
		
		return resultado;
	}

}

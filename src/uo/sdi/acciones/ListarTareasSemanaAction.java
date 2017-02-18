package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;

public class ListarTareasSemanaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String respuesta = "EXITO";
		
		TaskService taskService = Services.getTaskService();
		
		User user = (User)request.getSession().getAttribute("user");
		
		try {
			List<Task> tasks = taskService.findWeekTasksByUserId(user.getId());
			request.setAttribute("tasks", tasks);
		} catch (BusinessException e) {
			request.setAttribute("mensaje", e.getMessage());
			respuesta = "FRACASO";
		}
		
		return respuesta;
	}

}

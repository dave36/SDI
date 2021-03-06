package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;

public class AñadirTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		User user = (User)request.getSession().getAttribute("user");
		
		String idStr = request.getParameter("idCategoria");
		Long id = null;
		if(idStr!=null){
			try{
				id = Long.parseLong(idStr);
			}
			catch(NumberFormatException e){};
		}
		if(id==null){
			request.setAttribute("mensaje", "El id de la categoría no se pasó o era null");
			resultado = "FRACASO";
		}
		
		Task task = new Task();
		
		task.setTitle(request.getParameter("title"));
		task.setCategoryId(id);
		task.setUserId(user.getId());
		
		try {
			TaskService ts = Services.getTaskService();
			ts.createTask(task);	
			
			List<Task> tasks = ts.findTasksByCategoryId(id);
			request.setAttribute("tasks", tasks);
		} catch (BusinessException e) {
			resultado = "FRACASO";
			Log.debug("Error al crear la tarea");
		}
		
		return resultado;
	}

}

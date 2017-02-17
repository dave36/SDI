package uo.sdi.acciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;


public class ModificarTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado = "EXITO";
		
		try {
			Long id =Long.parseLong(request.getParameter("id"));
			
			TaskService ts = Services.getTaskService();
			Task task = ts.findTaskById(id);
			
			String title = request.getParameter("title");
			if(title!=null){
				task.setTitle(title);
			}
			String comments = request.getParameter("comments");
			if(comments!=null){
				task.setComments(comments);
			}
			String fecha = request.getParameter("planned");
			if(!fecha.equals("DD/MM/YYYY")){
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date date;
				date = format.parse(fecha);
				task.setPlanned(date);
			}
			
			Services.getTaskService().updateTask(task);
			
			TaskService taskService = Services.getTaskService();
			List<Task> tasks = taskService.findTodayTasksByUserId(task.getUserId());
			request.setAttribute("tasks", tasks);
		} catch (BusinessException e1) {
			request.setAttribute("error", e1.getMessage());
			resultado = "FRACASO";
		} catch (ParseException e) {
			request.setAttribute("error", "Formato de fecha no valido");
			resultado = "FRACASO";
		}	
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}

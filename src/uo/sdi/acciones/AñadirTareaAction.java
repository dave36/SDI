package uo.sdi.acciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;

public class AñadirTareaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Task task = new Task();
		
		task.setTitle(request.getParameter("title"));
		task.setComments(request.getParameter("comments"));
		
		String fecha = request.getParameter("planned");
//		if(!fecha.equals("DD/MM/YYYY")){
//			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//			Date date = null;
//			try {
//				date = format.parse(fecha);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			task.setPlanned(date);
//		}
		
//		if(nombre==null || nombre.equals("")){
//			return "FRACASO";
//		}
		
		try {
			TaskService ts = Services.getTaskService();
			ts.createTask(task);	
			
			List<Task> tasks = ts.findTodayTasksByUserId(task.getUserId());
			request.setAttribute("tasks", tasks);
		} catch (BusinessException e) {
			resultado = "FRACASO";
			Log.debug("Error al crear la tarea");
		}
		
		return resultado;
	}

}

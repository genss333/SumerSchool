package control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutData {
	
	public LogoutData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("Username");
		session.removeAttribute("g-user");
		response.sendRedirect(request.getContextPath()+"/IndexServlet");
	}

}

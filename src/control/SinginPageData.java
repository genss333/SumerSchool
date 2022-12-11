package control;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SinginPageData {

	NavbarData navbarData;

	public String errorMessage;

	public boolean failed;
	public boolean check = false;

	public SinginPageData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("============ SinginPageData ============");
		StringBuffer temp = new StringBuffer();

		// prepare navbar data
		try {
			System.out.println("============ prepare navbar data ============");
			navbarData = new NavbarData(request, response);
			System.out.println("============ Pepeare Alert Login Data ===============");
			HttpSession session = request.getSession();
			
			if(session.getAttribute("Loginfailed") == "Loginfailed"){
				request.setAttribute("alert", "Loginfailed");
				session.removeAttribute("Loginfailed");
			}
			
			if(session.getAttribute("PlaseLogin") == "PlaseLogin"){
				request.setAttribute("alert", "PlaseLogin");
				session.removeAttribute("PlaseLogin");
			}
			
			if(session.getAttribute("RegisterSuccess") == "RegisterSuccess"){
				check = true;
				request.setAttribute("alert", check);
				session.removeAttribute("RegisterSuccess");
			}

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "SinginPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "SinginPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "SinginPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "SinginPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}

	}


}

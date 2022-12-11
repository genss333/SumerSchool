package control;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AuthenDAO;

public class LoginData {
	
	public String errorMessage;

	public boolean failed;

	public LoginData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("============ LoginData ============");

		StringBuffer temp = new StringBuffer();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		try {
			
			Pattern emailpatern = Pattern.compile("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+(\\.[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*)*@[gmail]+(\\.[com]*)*");
			Pattern passwordstr = Pattern.compile("[^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$]");
			Matcher matcheremail = emailpatern.matcher(email);
			Matcher matcherpass = passwordstr.matcher(password);
			boolean found = false;
			boolean strength = false;
			
			while (matcheremail.find() && matcherpass.find()) {
				System.out.println(
						String.format("I found the email" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
								matcheremail.group(), matcheremail.start(), matcheremail.end()));
				System.out.println(
						String.format("I found the password" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
								matcherpass.group(), matcherpass.start(), matcherpass.end()));
				found = true;
				strength = true;

			}
			
			if (!found) {
				failed = true;
				String msg = "No match found. email: " + email + " and password: "+ password;
				temp.append(msg).append("\n");
				System.out.println("No match found." + email+ " and password: "+ password);

			} else {
				AuthenDAO dao = new AuthenDAO();
				if(strength) {
					if (dao.Singin(email, password)) {
						session.setAttribute("Username", email);
						session.setAttribute("LoginSuccess", "LoginSuccess");
						response.sendRedirect(request.getContextPath() + "/IndexServlet");
					} else {
						session.setAttribute("Loginfailed", "Loginfailed");
						response.sendRedirect(request.getContextPath() + "/SinginServlet");
					}
				}else {
					failed = true;
					String msg = "password is sickness." + password;
					temp.append(msg).append("\n");
					System.out.println("password is sickness." + password);
				}
			}

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "LoginData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "LoginData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "LoginData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "LoginData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}

	}
}

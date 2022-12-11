package control;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AuthenDAO;
import model.Authen;

public class RegisterData {
	
	public String errorMessage;

	public boolean failed;
	
	public RegisterData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("============ RegisterData ============");

		StringBuffer temp = new StringBuffer();
		HttpSession session = request.getSession();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeat = request.getParameter("repeatpass");
		
		try {
			
			Pattern Strpattern = Pattern.compile("[a-zA-Z]+");
			Pattern emailpatern = Pattern.compile("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+(\\.[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*)*@[gmail]+(\\.[com]*)*");
			Pattern passwordstr = Pattern.compile("[^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$]");
			boolean found = false;
			boolean strength = false;
			Matcher fnamematcher = Strpattern.matcher(fname);
			Matcher lnamematcher = Strpattern.matcher(lname);
			Matcher matcheremail = emailpatern.matcher(email);
			Matcher matcherpass = passwordstr.matcher(password);
			
			while(fnamematcher.find() && lnamematcher.find() && matcheremail.find() && matcherpass.find()) {
				System.out.println(
						String.format("I found the firstname" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
								fnamematcher.group(), fnamematcher.start(), fnamematcher.end()));
				System.out.println(
						String.format("I found the lastname" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
								lnamematcher.group(), lnamematcher.start(), lnamematcher.end()));
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
				String msg = "No match found.";
				temp.append(msg).append("\n");
				System.out.println("No match found.");

			}else {
				AuthenDAO dao = new AuthenDAO();
				Authen auth = new Authen(fname, lname, email, password);
				
				if(strength) {
					if (password.equals(repeat)) {
						if (dao.Singup(auth)) {
							session.setAttribute("RegisterSuccess", "RegisterSuccess");
							response.sendRedirect("SinginServlet");
						} else {
							response.sendRedirect("SingupServlet");
						}

					} else {
						response.sendRedirect("SingupServlet");
					}
					
				}else {
					failed = true;
					String msg = "password is sickness." + password;
					temp.append(msg).append("\n");
					System.out.println("password is sickness." + password);
				}
			}
			
		}catch (NumberFormatException ex) {
			System.out.println("Class:" + "RegisterData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "RegisterData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "RegisterData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "RegisterData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}
		
	}

}

package control;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AuthenDAO;
import model.Authen;
import model.Book;

public class UserAccountData {

	public String errorMessage;

	public boolean failed;

	public UserAccountData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("============ UserAccountData ============");

		StringBuffer temp = new StringBuffer();

		try {

			HttpSession session = request.getSession();
			String emailold = String.valueOf(session.getAttribute("Username"));
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipcode = request.getParameter("zipcode");

			Pattern emailpatern = Pattern.compile(
					"[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+(\\.[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*)*@[gmail]+(\\.[com]*)*");
			Pattern Strpattern = Pattern.compile("[a-zA-Z]");
			Pattern Numberpattern = Pattern.compile("[0-9]");

			Matcher matcheremail = emailpatern.matcher(email);
			Matcher matcherfname = Strpattern.matcher(fname);
			Matcher matcherlname = Strpattern.matcher(lname);
			Matcher matcherphone = Numberpattern.matcher(phone);
			Matcher matcherstreet = Numberpattern.matcher(street);
			Matcher matchercity = Strpattern.matcher(city);
			Matcher matcherstate = Strpattern.matcher(state);
			Matcher matchezipcode = Numberpattern.matcher(zipcode);
			boolean found = false;

			while (matcheremail.find() && matcherfname.find() && matcherlname.find() && matcherphone.find()
					&& matcherstreet.find() && matchercity.find() && matcherstate.find() && matchezipcode.find()) {
				System.out.println(String.format(
						"I found the email" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
						matcheremail.group(), matcheremail.start(), matcheremail.end()));
				System.out.println(String.format(
						"I found the firstname" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
						matcherfname.group(), matcherfname.start(), matcherfname.end()));
				System.out.println(String.format(
						"I found the lastname" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
						matcherlname.group(), matcherlname.start(), matcherlname.end()));
				System.out.println(String.format(
						"I found the phone" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
						matcherphone.group(), matcherphone.start(), matcherphone.end()));
				System.out.println(String.format(
						"I found the street" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
						matcherstreet.group(), matcherstreet.start(), matcherstreet.end()));
				System.out.println(String.format(
						"I found the city" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
						matchercity.group(), matchercity.start(), matchercity.end()));
				System.out.println(String.format(
						"I found the state" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
						matcherstate.group(), matcherstate.start(), matcherstate.end()));
				System.out.println(String.format(
						"I found the zipcode" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
						matchezipcode.group(), matchezipcode.start(), matchezipcode.end()));

				found = true;
			}

			if (!found) {
				failed = true;
				String msg = "No match found. email=" + email + " firstname=" + fname + " lastname=" + lname + " phone="
						+ phone + "\n" + " street=" + street + " city=" + city + " state=" + state + " zipcode="
						+ zipcode;
				temp.append(msg).append("\n");
				
				System.out.println("No match found. email=" + email + " firstname=" + fname + " lastname=" + lname
						+ " phone=" + phone + "\n" + " street=" + street + " city=" + city + " state=" + state
						+ " zipcode=" + zipcode);

			}else {
				
				AuthenDAO dao = new AuthenDAO();
				Authen auth = new Authen(fname, lname, email, "");
				Book book = new Book(email, "", phone, street, city, state, zipcode);

				if (dao.UpdateUser(auth, book, emailold)) {
					session.setAttribute("UpdateSuccess", "UpdateSuccess");
					response.sendRedirect(request.getContextPath() + "/AccountServlet");
				} else {
					session.setAttribute("UpdateFailed", "UpdateFailed");
					response.sendRedirect(request.getContextPath() + "/AccountServlet");
				}
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

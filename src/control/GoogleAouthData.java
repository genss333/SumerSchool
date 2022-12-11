package control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import model.GoogleAuth;
import servieces.IdTokenVerifierAndParser;

public class GoogleAouthData {

	public String errorMessage;

	public boolean failed;

	public GoogleAouthData(HttpServletRequest request, HttpServletResponse respons) {
		System.out.println("============ GoogleAouthData ============");
		StringBuffer temp = new StringBuffer();

		try {
			String idToken = request.getParameter("id_token");
			GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
			
			if (payLoad != null) {
				
	            String name = (String) payLoad.get("name");
	            String pictureUrl = (String) payLoad.get("picture");
	            String g_email = payLoad.getEmail();
	            String familyName = (String) payLoad.get("family_name");
	            String givenName = (String) payLoad.get("given_name");
	            
	            GoogleAuth g_auth = new GoogleAuth(g_email, pictureUrl, name, givenName, familyName);
	            List<GoogleAuth> g_authList = new ArrayList<GoogleAuth>();
	            g_authList.add(g_auth);
	            System.out.println(g_authList);
	            
				HttpSession session = request.getSession(true);
				session.setAttribute("g-user", g_authList);
				session.setAttribute("GoogleSuccess", "GoogleSuccess");
				respons.sendRedirect("IndexServlet");
				
			}else {
				respons.sendRedirect("SinginServlet");
			}

		} catch (Exception ex) {
			System.out.println("Class:" + "GoogleAouthData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}
	}

}

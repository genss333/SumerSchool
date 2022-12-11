package control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductsDAO;
import model.Cart;
import model.Products;

public class CartActionData {
	
	public String errorMessage;

	public boolean failed;
	
	public void AddToCart(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("============ AddToCart ============");

		StringBuffer temp = new StringBuffer();
		try {
			int id = Integer.valueOf(request.getParameter("id"));
			int qty = Integer.valueOf(request.getParameter("qty"));

			ArrayList<Cart> cartList = new ArrayList<>();
			Cart cm = new Cart();
			cm.setId(id);
			cm.setQuantity(qty);
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

			if (cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect(request.getContextPath() + "/CartServlet");
			} else {
				cartList = cart_list;
				boolean exist = false;
				for (Cart c : cart_list) {
					if (c.getId() == id) {
						exist = true;
						c.setQuantity(qty);
						response.sendRedirect(request.getContextPath() + "/CartServlet");
					}
				}

				if (!exist) {
					cartList.add(cm);
					response.sendRedirect(request.getContextPath() + "/CartServlet");
				}
			}
		}catch (NumberFormatException ex) {
			System.out.println("Class:" + "AddToCart, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "AddToCart, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}
	}

	public void RemoveCart(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("============ RemoveCart ============");

		StringBuffer temp = new StringBuffer();
		try {
			String bookId = request.getParameter("id");
			if (bookId != null) {
				ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
				if (cart_list != null) {
					for (Cart c : cart_list) {
						if (c.getId() == Integer.parseInt(bookId)) {
							cart_list.remove(cart_list.indexOf(c));
							break;
						}
					}
				}
				response.sendRedirect(request.getContextPath() + "/CartServlet");

			} else {
				response.sendRedirect(request.getContextPath() + "/CartServlet");
			}

		}catch (NumberFormatException ex) {
			System.out.println("Class:" + "RemoveCart, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "RemoveCart, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}
	}
	
	public void UpdateCart(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("============ UpdateCart ============");

		StringBuffer temp = new StringBuffer();
		try {
			
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			List<Products> products = ProductsDAO.ProductsDetail(id);

			if (action != null && id >= 1) {
				if (action.equals("inc")) {
					for (Cart c : cart_list) {
						if (c.getId() == id) {
							for(Products p : products) {
								int quantity = c.getQuantity();
								quantity++;
								if(quantity <= p.stk) {
									c.setQuantity(quantity);
								}else {
									c.setQuantity(p.stk);
								}
								response.sendRedirect(request.getContextPath() + "/CartServlet");
							}
						}
							
					}
				}

			} else {
				response.sendRedirect(request.getContextPath() + "/CartServlet");
			}
			
		}catch (NumberFormatException ex) {
			System.out.println("Class:" + "UpdateCart, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "UpdateCart, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}
		
	}
	
	public void MinusCart(HttpServletRequest request, HttpServletResponse response){
		System.out.println("============ MinusCart ============");

		StringBuffer temp = new StringBuffer();
		try {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

			if (action != null && id >= 1) {
				if (action.equals("dec")) {
					for (Cart c : cart_list) {
						if (c.getId() == id) {
							int quantity = c.getQuantity();
							quantity--;
							if(quantity>=1) {
								c.setQuantity(quantity);
								response.sendRedirect(request.getContextPath() + "/CartServlet");
							}else {
								response.sendRedirect(request.getContextPath() + "/CartServlet");
							}
							
						}
					}
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/CartServlet");
			}
		}catch (NumberFormatException ex) {
			System.out.println("Class:" + "UpdateCart, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "UpdateCart, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}
	}
	

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListItemHelper dao = new ListItemHelper();
		String act = request.getParameter("doThisToItem");

		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewAllItemsServlet";
		
		if (act.equals("Delete Book")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListItem itemToDelete = dao.searchForItemById(tempId);
				dao.deleteItem(itemToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if (act.equals("Edit Book")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListItem itemToEdit = dao.searchForItemById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/edit-item.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if (act.equals("Add Book")) {
			try {
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String category = request.getParameter("category");
				if(!title.isEmpty() && !author.isEmpty() && !category.isEmpty()) {
					ListItem itemToAdd = new ListItem(title, author, category);
					request.setAttribute("itemToAdd", itemToAdd);
					path = "/addItemServlet";
				} else {
					throw new NullPointerException("Null value error");
				}
			} catch (NullPointerException e) {
				System.out.println("Forgot to enter everything for an item");
			}

		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}

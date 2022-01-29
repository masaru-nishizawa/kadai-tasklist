package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskDTO;

/**
 * Servlet implementation class newServlet
 */
@WebServlet("/new")
public class newServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public newServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("TaskDTO",new TaskDTO());
        request.setAttribute("_token", request.getSession().getId());

        RequestDispatcher rd  = request.getRequestDispatcher("/WEB-INF/views/new.jsp");
        rd.forward(request, response);

    }

}

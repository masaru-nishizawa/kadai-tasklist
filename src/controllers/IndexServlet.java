package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskDTO;
import utils.DBUtil;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<TaskDTO> t = em.createNamedQuery("getAllTaskDTO",TaskDTO.class).getResultList();
        response.getWriter().append(Integer.valueOf(t.size()).toString());

        em.close();

        request.setAttribute("tasks",t);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        rd.forward(request, response);
    }

}

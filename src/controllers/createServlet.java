package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskDTO;
import utils.DBUtil;

/**
 * Servlet implementation class createServlet
 */
@WebServlet("/create")
public class createServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public createServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        TaskDTO task = new TaskDTO();

        String content = request.getParameter("content");
        task.setContent(content);

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        task.setTime_created(currentTime);
        task.setTime_updated(currentTime);

        em.persist(task);
        em.getTransaction().commit();

        em.close();

        response.sendRedirect(request.getContextPath()+"/index");
    }

}

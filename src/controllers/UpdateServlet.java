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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");

        if (_token!=null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();
            TaskDTO task = em.find(TaskDTO.class, (Integer)(request.getSession().getAttribute("task_id")));

            task.setContent(request.getParameter("content"));

            Timestamp current_time = new Timestamp(System.currentTimeMillis());
            task.setTime_updated(current_time);

            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();
            request.getSession().setAttribute("flush", "更新が完了しました");

            response.sendRedirect(request.getContextPath()+"/index");
        }


    }

}

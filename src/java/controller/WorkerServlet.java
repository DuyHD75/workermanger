package controller;

import dao.WorkerDAO;
import entity.Worker;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.util.*;

@WebServlet(name = "WorkerServlet", urlPatterns = {"/workers"})
public class WorkerServlet extends HttpServlet {

    private WorkerDAO workerDAO;

    @Override
    public void init() throws ServletException {
        workerDAO = new WorkerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "delete":
                    deleteWorker(request, response);
                    break;
                default:
                    viewAllWorker(request, response);
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        action = null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createWorker(request, response);
                    break;
                case "update":
                    updateWorker(request, response);
                    break;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        action = null;
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("workerForms/createForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Worker worker = workerDAO.getWorkerById(id);
        request.setAttribute("worker", worker);
        RequestDispatcher dispatcher = request.getRequestDispatcher("workerForms/updateForm.jsp");
        dispatcher.forward(request, response);
    }

    private void viewAllWorker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Worker> workers = workerDAO.getAllWorkers();

        request.setAttribute("workers", workers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("workerForms/workerList.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteWorker(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        workerDAO.deleteWorker(id);
        List<Worker> workers = workerDAO.getAllWorkers();
        request.setAttribute("workers", workers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("workerForms/workerList.jsp");
        dispatcher.forward(request, response);
    }

    private void createWorker(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        Worker worker = new Worker(name, address, email);

        workerDAO.insertWorker(worker);

        viewAllWorker(request, response);


    }

    private void updateWorker(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        Worker worker = new Worker(id, name, address, email);

        workerDAO.updateWorker(worker);

        viewAllWorker(request, response);

//        request.setAttribute("message", "Worker was updated !");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("workerForms/updateForm.jsp");
//        dispatcher.forward(request, response);
    }

}

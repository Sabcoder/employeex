package servlets;

import DAO.Factory;
import employees.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nikita Philippov on 29.12.16.
 */
@WebServlet("/start")
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String greetings = "Welcome to ";
        req.setAttribute("greetings", greetings);

        String projectName = "EmployeeX";
        req.setAttribute("projectName", projectName);

        List<Person> people;
        people = (List<Person>) Factory.getInstance().getPersonDAO().getAllEntities();
        req.setAttribute("employeeList", people);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);



    }
}

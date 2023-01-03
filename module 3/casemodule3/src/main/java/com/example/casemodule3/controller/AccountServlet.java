package com.example.quanlymu.controller;

import com.example.quanlymu.models.Account;
import com.example.quanlymu.services.AccountService;
import com.example.quanlymu.services.IAccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "AccountServlet", urlPatterns = "accounts")
public class AccountServlet extends HttpServlet {
    private IAccountService iAccountServlet = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createAccount(request, response);
                break;
            case "edit":
                updateAccount(request, response);
                break;
            case "delete":
                deleteAccount(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            default:
                listCustomers(request, response);
                break;
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Account> customers = this.iAccountServlet.findAll();
        request.setAttribute("accounts", iAccountServlet);

        RequestDispatcher dispatcher = request.getRequestDispatcher("account/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("account/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String fullName = request.getParameter("fullName");
        Integer age = Integer.valueOf(request.getParameter("age"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int id = (int)(Math.random() * 10000);

        Account account = new Account(id,  username,  password,  role,  fullName,  age,  phone,  email);
        this.iAccountServlet.saveAccount(account);
        RequestDispatcher dispatcher = request.getRequestDispatcher("account/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        Account account = this.iAccountServlet.findById(id);
        RequestDispatcher dispatcher;
        if(account == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("account", account);
            dispatcher = request.getRequestDispatcher("account/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String fullName = request.getParameter("fullName");
        Integer age = Integer.valueOf(request.getParameter("age"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Account account = this.iAccountServlet.findById(id);
        RequestDispatcher dispatcher;
        if(account == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            account.setUsername(username);
            account.setPassword(password);
            account.setRole(role);
            account.setFullName(fullName);
            account.setAge(age);
            account.setPhone(phone);
            account.setEmail(email);

            this.iAccountServlet.update(id , account);
            request.setAttribute("account", account);
            request.setAttribute("message", "Account information was updated");
            dispatcher = request.getRequestDispatcher("account/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Account account = this.iAccountServlet.findById(id);
        RequestDispatcher dispatcher;
        if(account == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("account", account);
            dispatcher = request.getRequestDispatcher("account/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Account account = this.iAccountServlet.findById(id);
        RequestDispatcher dispatcher;
        if(account == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.iAccountServlet.remove(id);
            try {
                response.sendRedirect("/accounts");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Account account = this.iAccountServlet.findById(id);
        RequestDispatcher dispatcher;
        if(account == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("account", account);
            dispatcher = request.getRequestDispatcher("account/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

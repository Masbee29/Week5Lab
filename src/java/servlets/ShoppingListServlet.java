/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mason
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        if(request.getParameter("logout") != null) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        if((String)session.getAttribute("username") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");    
        ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
        
        if(session.getAttribute("username") == null) {
            session.setAttribute("username", (String)request.getParameter("username"));
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
        if(items == null)
               items = new ArrayList<String>();
     
        String item;
        switch(action) {
            case "Add":
                item = request.getParameter("additem");
                if(item == null || item.equals("")) {
                }
                else{
                    items.add(item);
                }   
                break;
                
            case "Delete":
                if(!items.isEmpty()) {
                    item = (String)request.getParameter("shopping_item");
                    items.remove(item);
                }
                
           
                break;
            default:
                break;
        }
        
        session.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}

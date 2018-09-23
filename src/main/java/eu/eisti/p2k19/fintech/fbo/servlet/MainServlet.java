package eu.eisti.p2k19.fintech.fbo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Le contrôleur affecte la valeur bar à l'attribut foo, il pourra être utilisé dans la vue
        request.setAttribute("foo", "bar");
        
        // Redirection de la requête vers une vue sample.jsp
        // Note : Tout ce qui se trouve sous WEB-INF n'est pas directement accessible, contrairement à index.jsp qui est à la racine de webapp
        this.getServletContext().getRequestDispatcher("/WEB-INF/sample.jsp").forward(request, response);
        
        super.doGet(request, response);
    }
    
}

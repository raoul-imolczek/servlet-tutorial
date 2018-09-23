package eu.eisti.p2k19.fintech.fbo.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.eisti.p2k19.fintech.fbo.credit.model.CreditImmobilier;
import eu.eisti.p2k19.fintech.fbo.credit.model.CreditPasRemboursableException;
import eu.eisti.p2k19.fintech.fbo.credit.model.TauxUsureException;

public class CalculatorServlet extends HttpServlet {
    
    private final static String APPORT = "apport";
    private final static String MONTANT = "montant";
    private final static String TAUX = "taux";
    private final static String MENSUALITE = "mensualite";
    private final static String DUREE = "duree";
    private final static String TAEG = "taeg";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if (request.getParameter(APPORT) == null || request.getParameter(APPORT).equals("") ||
            request.getParameter(MONTANT) == null || request.getParameter(MONTANT).equals("") ||
            request.getParameter(TAUX) == null || request.getParameter(TAUX).equals("") ||
            request.getParameter(MENSUALITE) == null || request.getParameter(MENSUALITE).equals("")) {
                
            this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
            return;            
            
        }
        
        double apport = Double.parseDouble(request.getParameter(APPORT));
        double montant = Double.parseDouble(request.getParameter(MONTANT));
        double tauxCredit = Double.parseDouble(request.getParameter(TAUX));
        double mensualite = Double.parseDouble(request.getParameter(MENSUALITE));
        
        try {

            CreditImmobilier credit = new CreditImmobilier(apport, montant, mensualite, tauxCredit, 0, 0, LocalDate.now());
            
            int duree = credit.getDuree();
            double taeg = credit.getTaeg();
            
            request.setAttribute(DUREE, duree);
            request.setAttribute(TAEG, taeg);
        
        } catch (TauxUsureException e) {
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/usure.jsp").forward(request, response);
            
        } catch (CreditPasRemboursableException e) {
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/nonremboursable.jsp").forward(request, response);
            
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
        
    }
    
}

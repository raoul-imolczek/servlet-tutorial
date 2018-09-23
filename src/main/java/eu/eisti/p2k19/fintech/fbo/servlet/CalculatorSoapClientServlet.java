package eu.eisti.p2k19.fintech.fbo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.eisti.p2k19.fintech.fbo.credit.calcul.service.CreditPasRemboursableException_Exception;
import eu.eisti.p2k19.fintech.fbo.credit.calcul.service.TauxUsureException_Exception;
import eu.eisti.p2k19.fintech.fbo.credit.calcul.service.CalculCreditService_Service;
import eu.eisti.p2k19.fintech.fbo.credit.calcul.service.CalculCreditService;
import eu.eisti.p2k19.fintech.fbo.credit.calcul.service.ResultatCalculCredit;

public class CalculatorSoapClientServlet extends HttpServlet {
    
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

            CalculCreditService_Service service = new CalculCreditService_Service();
            CalculCreditService client = service.getCalculCreditServiceImplPort();
 
            ResultatCalculCredit resultat = client.calculCredit(montant, apport, tauxCredit, mensualite);
            
            request.setAttribute(DUREE, resultat.getDuree());
            request.setAttribute(TAEG, resultat.getTaeg());
        
        } catch (TauxUsureException_Exception e) {
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/usure.jsp").forward(request, response);
            
        } catch (CreditPasRemboursableException_Exception e) {
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/nonremboursable.jsp").forward(request, response);
            
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
        
    }
    
}

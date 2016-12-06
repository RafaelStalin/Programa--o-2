package intermediarios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import loja.Produto;

/**
 *
 * @author Vagner
 */
@WebServlet(name = "BuscarProduto", urlPatterns = {"/BuscarProduto"})
public class BuscarProduto extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Produto p = new Produto("", "", 0, 0);
            
            p.listaProdutos();
            out.print("<table class='table table-striped'>");
            
            out.print("<tr align='center'>");
            out.print("<td>Produto</td>");
            out.print("<td>Quantidade</td>");
            out.print("<td>Selecione</td>");
            out.print("</tr>");
            
            for(int x = 0; x < p.listaProdutos().size(); x++){
                out.print("<tr align='center'>");
                out.print("<td>"+ p.listaProdutos().get(x).getProdutosnome() +"</td>");
                out.print("<td>"+ p.listaProdutos().get(x).getProdutosqtd()+"</td>");
                out.print("<td><input id='produto' name='produto' type='checkbox' value='"+ p.listaProdutos().get(x).getIdprodutos() +"'></td>");
                out.print("</tr>");
               
            }
            
            out.print("</table>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

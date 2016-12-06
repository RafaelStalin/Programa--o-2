
package intermediarios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import loja.Cliente;

@WebServlet(name = "AdicionarCliente", urlPatterns = {"/AdicionarCliente"})
public class AdicionarCliente extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
      
            String nomecliente  = request.getParameter("nomecliente");
            String emailcliente = request.getParameter("emailcliente");
            String cpfcliente   = request.getParameter("cpfcliente");
            String endcliente   = request.getParameter("endcliente");
            
           Cliente cliente = new Cliente(nomecliente,emailcliente,cpfcliente,endcliente,0);

            cliente.novoCliente();
           
            if(cliente.validaNovoCliente() == true){
                
                out.print("<div class='bg-success'>Cliente Cadastrado com Sucesso</div>");
                out.print("<a href='cad_cliente.html'>Voltar</a>");
   
            }else {
                out.print("<div class='bg-danger'>Cliente com cpf já cadastrado, favor revise seus dados</div>");
                out.print("<a href='cad_cliente.html'><<-Voltar</a>");
            }
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

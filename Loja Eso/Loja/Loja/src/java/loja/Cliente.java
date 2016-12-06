package loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dados.Banco;
import java.util.ArrayList;

public class Cliente {
	
	
	private String nomeCliente;
	private String emailCliente;
	private String cpfCliente;
	private String endCliente;
        private Boolean r;
        private int     idCliente;

 
        
	
	
	
	public Cliente(String nomeCliente, String emailCliente, String cpfCliente, String endCliente, int idCliente) {
		
           this.nomeCliente     = nomeCliente;
           this.emailCliente    = emailCliente;
           this.cpfCliente      = cpfCliente;
           this.endCliente      = endCliente;
           this.idCliente       = idCliente;
           r                    = false;
           
           
         }

	public String getName() {
		return nomeCliente;
	}
	
	public void setName(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getEmail() {
		return emailCliente;
	}
	
	public void setEmail(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	public String getCpf() {
		return cpfCliente;
	}
	
	public void setCpf(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	public String getEnd() {
		return endCliente;
	}
	
	public void setEnd(String endCliente) {
		this.endCliente = endCliente;
	}
        
        public int getIdCliente() {
                return idCliente;
        }

        public void setIdCliente(int idCliente) {
            this.idCliente = idCliente;
        }
        
        public boolean validaNovoCliente(){
            this.r = r;
            return r;
        }
	
	public boolean verficaCpfCliente(String cpfCliente){
		
		Connection conecta = new Banco().getConnection();
		
				
		String sql = "select * from clientes WHERE clientescpf = ?";
		
		
		PreparedStatement query;
		try {
			query = conecta.prepareStatement(sql);
			query.setString(1, cpfCliente);
                        ResultSet rs = query.executeQuery();
                        int registro = 0;
                        while (rs.next()) {
                         registro ++;
                        
                        }
                        rs.close();
                        query.close();
                        conecta.close();

                        if(registro >= 1){
            	
                            return true;
            	
                        }else {

                            return false;
                        }
            
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                                return false;


                        }
	
	
	
	
	public void novoCliente() {
		
		Connection conexao = new Banco().getConnection();
		
		Boolean rsCliente = verficaCpfCliente(cpfCliente);
		
		if(rsCliente == false){
			
			String sql = "insert into clientes (clientesnome, clientesemail,clientescpf,clientesend) values (?, ?, ?, ?)";
			
			PreparedStatement query;
			try {
				query = conexao.prepareStatement(sql);
                                query.setString(1, getName());
                                query.setString(2, getEmail());
                                query.setString(3, getCpf());
                                query.setString(4, getEnd());
	            
                                query.execute();
                                query.close();
                                conexao.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
			
                        r = true;
		} //Fim if
                else {
                    
                    r = false;
                }
		
		
	}
			
		
    public ArrayList<Cliente> listaClientes(){
        
        Connection conecta = new Banco().getConnection();
		
				
	String sql = "select * from clientes";
	ArrayList<Cliente> ls = new ArrayList<Cliente>();	
		
	PreparedStatement query;
            try {
		query = conecta.prepareStatement(sql);
                ResultSet rs = query.executeQuery();
                
                while (rs.next()) {
                    
                    int idclientes = rs.getInt("idclientes");
                    String clientesnome = rs.getString("clientesnome");
                    String clientesemail = rs.getString("clientesemail");
                    String clientescpf = rs.getString("clientescpf");
                    String clientesend = rs.getString("clientesend");
                    
                    Cliente c = new Cliente(clientesnome, clientesemail, clientescpf, clientesend, idclientes);
                    
                    ls.add(c);
                        
                }
                rs.close();
                query.close();
                conecta.close();

                                    
                } catch (SQLException e) {
                  e.printStackTrace();
                }
            return ls;
    }
}

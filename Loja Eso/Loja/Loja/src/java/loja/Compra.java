package loja;

import dados.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Vagner
 */
public class Compra {

    
    private int cidClientes;
    private int cidProdutos;
    
    public Compra(int cidClientes,int cidProdutos) {
        this.cidClientes = cidClientes;
        this.cidProdutos = cidProdutos;
    }
     public int getCidClientes() {
        return cidClientes;
    }

    public void setCidClientes(int cidClientes) {
        this.cidClientes = cidClientes;
    }

    public int getCidProdutos() {
        return cidProdutos;
    }

    public void setCidProdutos(int cidProdutos) {
        this.cidProdutos = cidProdutos;
    }
    
    public void realizarCompra(){
        
        
        
        Connection conexao = new Banco().getConnection();

			String sql = "insert into itens (idclientes, idprodutos,qtdselecionada) values (?, ?, 1)";
                        String sql2 = "UPDATE produtos set produtosqtd = produtosqtd -1 WHERE idprodutos = ? ";
			
			PreparedStatement query;
                        PreparedStatement query2;
			try {
				query = conexao.prepareStatement(sql);
                                query.setInt(1, getCidClientes());
                                query.setInt(2, getCidProdutos());

                                query.execute();
                                query.close();
                                
                                
                                query2 = conexao.prepareStatement(sql2);
                                query2.setInt(1, getCidProdutos());
                                

                                query2.execute();
                                query2.close();
                                
                                conexao.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
			
                       
       
    }
    
}

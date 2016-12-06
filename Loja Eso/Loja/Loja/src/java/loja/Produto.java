package loja;

import dados.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vagner
 */
public class Produto {
    
  
  private String produtosnome;
  private String produtosdsc;
  private int produtosqtd;
  private int idprodutos;

    public Produto(String produtosnome, String produtosdsc, int produtosqtd, int idprodutos) {
        this.produtosnome = produtosnome;
        this.produtosdsc = produtosdsc;
        this.produtosqtd = produtosqtd;
        this.idprodutos = idprodutos;
    }

    public String getProdutosnome() {
        return produtosnome;
    }

    public void setProdutosnome(String produtosnome) {
        this.produtosnome = produtosnome;
    }

    public String getProdutosdsc() {
        return produtosdsc;
    }

    public void setProdutosdsc(String produtosdsc) {
        this.produtosdsc = produtosdsc;
    }

    public int getProdutosqtd() {
        return produtosqtd;
    }

    public void setProdutosqtd(int produtosqtd) {
        this.produtosqtd = produtosqtd;
    }
    public int getIdprodutos() {
        return idprodutos;
    }

    public void setIdprodutos(int idprodutos) {
        this.idprodutos = idprodutos;
    }
  
  public void novoProduto() {
		
		Connection conexao = new Banco().getConnection();
		
			String sql = "insert into produtos (produtosqtd, produtosdsc, produtosnome) values (?, ?, ?)";
			
			PreparedStatement query;
			try {
				query = conexao.prepareStatement(sql);
                                query.setInt(1, getProdutosqtd());
                                query.setString(2, getProdutosdsc());
                                query.setString(3, getProdutosnome());
	            
                                query.execute();
                                query.close();
                                conexao.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
          
		}
               
		
	public ArrayList<Produto> listaProdutos(){
            
            Connection conecta = new Banco().getConnection();
		
				
            String sql = "select * from produtos";
            ArrayList<Produto> ls = new ArrayList<Produto>();	

            PreparedStatement query;
                try {
                    query = conecta.prepareStatement(sql);
                    ResultSet rs = query.executeQuery();

                    while (rs.next()) {

                        int idprodutos = rs.getInt("idprodutos");
                        int produtosqtd = rs.getInt("produtosqtd");
                        String produtosdsc = rs.getString("produtosdsc");
                        String produtosnome = rs.getString("produtosnome");
                        

                        Produto p = new Produto(produtosnome, produtosdsc, produtosqtd, idprodutos);
                        if(produtosqtd > 0){
                        ls.add(p);
                        }

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

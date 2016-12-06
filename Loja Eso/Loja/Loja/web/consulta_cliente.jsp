<%@page import="loja.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,intermediarios.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cadastrar Novo Cliente</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<link rel="stylesheet" href="estilo.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/qunit/qunit-1.11.0.js"></script>

<script type="text/javascript" src="js/mask/jquery.mask.js"></script>

</head>
	
	
	
	<body>

		<div id="painel">
			<div class="row">
			
			<div class="col-md-4 menu">
			
				<h4>Cliente</h4>
				
					<ul>	
						<li><a href="cad_cliente.html">Novo Cliente</a></li>
						<li><a href="">Consultar Cliente</a></li>
	
					</ul>
				
					
				<h4>Produtos</h4>
				
					<ul>	
						<li><a href="cad_produto.html">Novo Produto</a></li>
						<li><a href="">Consultar Produtos</a></li>
						
					
					</ul>
				
				<h4>Compras</h4>
				
					<ul>	
						<li><a href="nova_compra.html">Nova Compra</a></li>
						<li><a href="">Consultar Compras</a></li>
	
					</ul>
				
				
					
					
			</div>
			
			
			<div class="col-md-8 conteudo">
			
				<h3>Consultar Clientes</h3>
				
                                
                                <table class="table">
                                    <tr align="center">
                                        <td>Nome Cliente</td>
                                        <td>Cpf</td>
                                        <td>Email</td>
                                        <td>Ações</td>
                                    </tr>
                                    
                              
                                <% 
                                
                                Cliente c = new Cliente("","", "", "",0);
                                
                                ArrayList<Cliente> ls = c.listaClientes();
                                
                                for(int x = 0; x < ls.size(); x++){
                                    out.print("<tr align='center'>");
                                    out.print("<td>"+ ls.get(x).getName() +"</td>");
                                    out.print("<td>"+ ls.get(x).getCpf()+"</td>");
                                    out.print("<td>"+ ls.get(x).getEmail()+"</td>");
                                    out.print("<td><a href='#' class='edcliente' id='"+ ls.get(x).getIdCliente() +"'>Editar</a> - ");
                                    out.print("<a href='#' class='excliente' id='"+ ls.get(x).getIdCliente() +"'>Excluir</a></td>");
                                    out.print("</tr>");
                                    
                                }
                                
                                
                                %>
                    
                                </table>     
		</div>

			<script>
				$(document).ready(function(){
					
					$("#cpfcliente").mask("000.000.000-00");
					
					$('.excliente').click(function(e){
                                            
                                            
                                            var excliente = $(this).attr("id");
                                            
                                            var confirmarexcliente = confirm("Deseja realmente Excluir esse cliente?");
                                            
                                            if(confirmarexcliente){
                                                
                                                $.post('ExcluirCliente',{excliente:excliente},function(deletarcliente){
                                                   alert(deletarcliente);
                                                });
                                                
                                            }
                                        });
				
				});
			
			</script>

</body>
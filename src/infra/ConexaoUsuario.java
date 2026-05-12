package infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;

public class ConexaoUsuario {
	public Usuario buscarUsuario(String cpf, String senha) {
	    String sql = "SELECT * FROM usuario WHERE cpf = ? AND senhausuario = ?";
	    try (Connection conn = CriarConexao.getConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setString(1, cpf);
	        stmt.setString(2, senha);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            Usuario user = new Usuario();
	            user.setNome(rs.getString("nomeusuario"));
	            // No MySQL, o tinyint(1) é lido como boolean ou int. 
	            // Se isadmin for 1, ele é admin.
	            user.setAdmin(rs.getInt("isadmin") == 1); 
	            return user;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // Retorna null se não encontrar ou der erro
	}
	
	public void inserirUsuario(String nome, String cpf, String email, String senha) {
		
		String sql = "INSERT INTO  usuario (nomeusuario, cpf, emailusuario, senhausuario, isadmin) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn = CriarConexao.getConexao()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setString(2, cpf);
			stmt.setString(3, email);			
			stmt.setString(4, senha);
			stmt.setInt(5, 0);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao inserir novo usuario: "+e.getMessage());
		}
	}
}

package infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class ConexaoProduto {
	public void addProduto(Produto p) throws SQLException {
		Connection cn = CriarConexao.getConexao();
		Statement stmt = cn.createStatement();
		stmt.execute("INSERT INTO produto (nomeproduto, descricaoproduto, valorproduto, qtdproduto, unidade_idunidade) VALUES ('"+p.getNome()+"', '"+p.getDescricao()+"', "+p.getValor()+", "+p.getQtd()+", "+p.getIdunidade()+")");
		cn.close();
	}
	
	public String[] getProdutos() throws SQLException {
		
		List<String> pdts = new ArrayList<>();
		
		Connection cn = CriarConexao.getConexao();
		String sql = "select * from produto";
		
		PreparedStatement stmt = cn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getInt("idproduto"));
			p.setNome(rs.getString("nomeproduto"));
			p.setValor(rs.getDouble("valorproduto"));
			p.setQtd(rs.getInt("qtdproduto"));
			p.setDescricao(rs.getString("descricaoproduto"));
			
			pdts.add(p.toString());
		}
		
		cn.close();
		return pdts.toArray(new String[0]);
	}
}

package modelo;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private double valor;
	private int qtd;
	private int idunidade;

	public Produto() {

	}

	public Produto(String nome, String descricao, double valor, int qtd, int idunidade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.qtd = qtd;
		this.idunidade = idunidade;
	}

	public String toString() {
		return this.nome + "  Unidades: " + this.qtd + "\n   R$" + this.valor;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdunidade() {
		return idunidade;
	}

	public void setIdunidade(int idunidade) {
		this.idunidade = idunidade;
	}

}

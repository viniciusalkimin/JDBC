package br.com.alura.jdbc.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;

	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Produto: %d, %s, %s", this.id, this.nome, this.descricao);
	}

	public void setId(int id) {
		this.id = id;

	}

}

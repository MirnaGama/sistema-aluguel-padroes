package entidades;

// SIMPLES POR ENQUANTO -- SEU CRUD DEVE SER COM ABSTRACT FACTORY
public class Imovel {

	private int id;
	private String endereco;
	private boolean disponivel;
	private float area;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	} 
	
	
}

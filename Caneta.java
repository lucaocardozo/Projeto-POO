//Lucas Martins Cardozo - 1996770

public class Caneta{
	
	private int cod;
	private String marca;

	private Detalhes det;


//=================================================

	public void imprimir(){
		System.out.println("\n imprimir default");
	}

//=================================================
	public Caneta(){  //Default
		cod = 0;
		marca = "";
		det = new Detalhes();
	}

	public Caneta(int cod, String marca){ //sobrecarga-1
		this.cod = cod;
		this.marca = marca;
	}

//================================================

	public Detalhes getDet(){
		return det;
	}

	public void setDet(Detalhes det){
		this.det = det;
	}

//================================================

	public int getCod(){
		return cod;
	}

	public String getMarca(){
		return marca;
	}
	
	public void setCod(int cod){
		this.cod = cod;
	}

	public void setMarca(String marca){
		this.marca = marca;
	}

}
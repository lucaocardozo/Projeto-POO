//Lucas Martins Cardozo - 1996770

public class MarcaTexto extends Caneta{ 
	
	private int grossura;
	private String tipo;

//=================================================
	public MarcaTexto(){  //Default
		grossura = 0;
		tipo = "";
	}

	public MarcaTexto(int grossura, String tipo){ //sobrecarga-1
		this.grossura = grossura;
		this.tipo = tipo;
	}
//=================================================

	public int getGrossura(){
		return grossura;
	}

	public String getTipo(){
		return tipo;
	}

	public void setGrossura(int grossura) throws GroException{

		if(grossura <= 2){
			throw new GroException();
		}
		else{
			this.grossura = grossura;
		}
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
}
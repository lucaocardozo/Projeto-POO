//Lucas Martins Cardozo - 1996770

public class Pincel extends Caneta{ 
	
	private int tamanho;
	private String ponta;

//=================================================
	public Pincel (){  //Default
		tamanho = 0;
		ponta = "";
	}

	public Pincel (int tamanho, String ponta){ //sobrecarga-1
		this.tamanho = tamanho;
		this.ponta = ponta;
	}

	public int getTamanho(){
		return tamanho;
	}

	public String getPonta(){
		return ponta;
	}

	public void setTamanho(int tamanho){
		this.tamanho = tamanho;
	}
	
	public void setPonta(String ponta) throws PontaException{

		if(ponta.equalsIgnoreCase("Fina")){
			this.ponta = ponta;
		}
		else{
			throw new PontaException();
		}
	}
}

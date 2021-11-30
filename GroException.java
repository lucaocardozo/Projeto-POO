//Lucas Martins Cardozo - 1996770

public class GroException extends Exception{ 

	Leitura l = new Leitura();

	public void impGroMar(){
		System.out.println("\nA grossura deve ser superior a 2mm");
	}

	public MarcaTexto cnsGroMar(MarcaTexto mar){
		try{
			mar.setGrossura(Integer.parseInt(l.entDados("\nInforme a grossura correta: ")));
		}
		catch(GroException gre){
			gre.impGroMar();
			gre.cnsGroMar(mar);
		}
		catch(NumberFormatException nfe){
			System.out.println("\nA grossura deve ser do tipo inteiro");
			cnsGroMar(mar);		
		}

		return mar;

	}



}

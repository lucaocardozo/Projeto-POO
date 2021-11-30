//Lucas Martins Cardozo - 1996770

public class PontaException extends Exception{ 

	Leitura l = new Leitura();

	public void impPonPin(){
	
		System.out.println("\nA ponta deve ser 'Fina'! ");

	}


	public Pincel cnsPonPin(Pincel pin){
		try{
			pin.setPonta(l.entDados("\nInforme a ponta certa (so sera aceita ponta 'fina'): "));
		}
		catch(PontaException poe){
			poe.impPonPin();
			poe.cnsPonPin(pin);
		}

		return pin;

	}


}


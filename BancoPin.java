//Lucas Martins Cardozo - 1996770

import java.util.List;
import java.util.ArrayList;


public class BancoPin{
	
	private List<Pincel> BDPin = new ArrayList<Pincel>();

	private Pincel pin = new Pincel();

	private Leitura l = new Leitura();


	public List<Pincel> getBDPin(){
		return BDPin;
	}
//==============================================================================================================
	public Pincel consPinCod(Pincel pin){
		
		for(int i = 0; i < BDPin.size(); i++){
			if(BDPin.get(i).getCod() == pin.getCod()){
				return BDPin.get(i);
			}
		}
		return null;
	}
//===============================================================================================================
	public Pincel cadPin(Pincel Pin){
		boolean vaiCodPi = true;
	
		while(vaiCodPi){
			try{
				pin.setCod(Integer.parseInt(l.entDados("\nCodigo: ")));
				
				if(consPinCod(pin) == null){			
					vaiCodPi = false;
				}

				else{
					l.entDados("\n Já existe um Pincel com este codigo! - Pressione a tecla <Enter>");
					continue;	
				}

			}
			catch(NumberFormatException nfe){
				l.entDados("\n O código deve ser um valor inteiro - Pressione a tecla <Enter>");
				continue;
			}
		}
		
		pin.setMarca(l.entDados("Marca: "));
		pin.setTamanho(Integer.parseInt(l.entDados("Tamanho do pincel (em centimetros): ")));
		pin.getDet().setNomFab(l.entDados("Pais onde foi fabricado:"));
		
		boolean vaiCod2 = true;
		
		while(vaiCod2){
			try{
				pin.getDet().setCor(l.entDados("Cor: "));
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\n O codigo de registro deve ser um inteiro!- Pressione a tecla <Enter>" );
			}
		}

		boolean vaiPonPin = true;

		while(vaiPonPin){
			try{
				pin.setPonta(l.entDados("Ponta: "));
				break;
			}
			catch(PontaException poe){
				poe.impPonPin();
				pin = poe.cnsPonPin(pin);
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nA ponta deve ser um valor inteiro!");
				continue;
			}
		}
		return pin;
	}
//===============================================================================================================
	public void impPin(Pincel pin){

		System.out.println("\n Codigo...: "+ pin.getCod());
		System.out.println(" Marca: "+ pin.getMarca());
		System.out.println(" Ponta do pincel: "+ pin.getPonta());
		System.out.println(" Pais onde foi fabricado: "+ pin.getDet().getNomFab());
		System.out.println(" Cor: "+ pin.getDet().getCor());
		System.out.println(" Grossura: "+ pin.getTamanho());

		System.out.println("\n ==============================================");

		l.entDados("\n\t\t\t pressione a tecla <Enter> para continuar... ");

	}
//===============================================================================================================
	public Pincel alteraPin(Pincel pin){

		for(int i = 0; i < BDPin.size(); i++){

			if(BDPin.get(i).getMarca() == pin.getMarca()){

				pin = cadPin(pin);

				BDPin.set(i, pin);

				return BDPin.get(i);
			}
		}
		return null;
	}
//===============================================================================================================
	public Pincel excluiPin(Pincel pin){
		
		pin = consPinCod(pin);

		if(BDPin.remove(pin)){
			return pin;
		}
		return null;
	}

}//fim

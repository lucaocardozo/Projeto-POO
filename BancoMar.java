//Lucas Martins Cardozo - 1996770

import java.util.List;
import java.util.ArrayList;


public class BancoMar{
	
	private List<MarcaTexto> BDMar = new ArrayList<MarcaTexto>();

	private MarcaTexto mar = new MarcaTexto();

	private Leitura l = new Leitura();


	public List<MarcaTexto> getBDMar(){
		return BDMar;
	}

//===============================================================================================================
	public MarcaTexto consMarCod(MarcaTexto mar){
		
		for(int i = 0; i < BDMar.size(); i++){
			if(BDMar.get(i).getCod() == mar.getCod()){
				return BDMar.get(i);
			}
		}

		return null;
	
	}
//===============================================================================================================
	public MarcaTexto cadMar(MarcaTexto Mar){

		boolean vaiCodMa = true;
	
		while(vaiCodMa){
			try{
				mar.setCod(Integer.parseInt(l.entDados("\nCodigo: ")));
				
				if(consMarCod(mar) == null){			
					vaiCodMa = false;
				}

				else{
					l.entDados("\n Já existe um Marca Texto com este codigo! - Pressione a tecla <Enter>");
					continue;	
				}
			}

			catch(NumberFormatException nfe){
				l.entDados("\n O código deve ser um valor inteiro - Pressione a tecla <Enter>");
				continue;
			}
		}
		
		mar.setMarca(l.entDados("Marca: "));
		mar.setTipo(l.entDados("Tipo de marca texto: "));
		mar.getDet().setNomFab(l.entDados("Pais onde foi fabricado:"));

		boolean vaiCod = true;
		
		while(vaiCod){
			try{
				mar.getDet().setCor(l.entDados("Cor: "));
				break;
			}

			catch(NumberFormatException nfe){
				l.entDados("\n O codigo de registro deve ser um inteiro!- Pressione a tecla <Enter>" );
			}
		}

		boolean vaiGroMar = true;

		while(vaiGroMar){
			try{
				mar.setGrossura(Integer.parseInt(l.entDados("Grossura: ")));
				break;
			}
			catch(GroException gre){
				gre.impGroMar();
				mar = gre.cnsGroMar(mar);
				break;
			}
			catch(NumberFormatException nfe){
				l.entDados("\nA grossura deve ser um valor inteiro!");
				continue;
			}
		}

		return mar;
	}
//===============================================================================================================
	public void impMar(MarcaTexto mar){

		System.out.println("\n Codigo...: "+ mar.getCod());
		System.out.println(" Marca: "+ mar.getMarca());
		System.out.println(" Tipo de marca texto: "+ mar.getTipo());
		System.out.println(" Pais onde foi fabricado: "+ mar.getDet().getNomFab());
		System.out.println(" Cor: "+ mar.getDet().getCor());
		System.out.println(" Grossura: "+ mar.getGrossura());

		System.out.println("\n ==============================================");

		l.entDados("\n\t\t\t pressione a tecla <Enter> para continuar... ");

	}
//===============================================================================================================
	public MarcaTexto alteraMar(MarcaTexto mar){

		for(int i = 0; i < BDMar.size(); i++){

			if(BDMar.get(i).getMarca() == mar.getMarca()){

				mar = cadMar(mar);

				BDMar.set(i, mar);

				return BDMar.get(i);
			}
		}
		return null;

	}
//===============================================================================================================
	public MarcaTexto excluiMar(MarcaTexto mar){
		
		mar = consMarCod(mar);

		if(BDMar.remove(mar)){
			return mar;
		}

		return null;


	}
}//fim

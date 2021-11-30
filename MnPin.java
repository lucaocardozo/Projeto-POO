//Lucas Martins Cardozo - 1996770

public class MnPin{ 

	private BancoPin bancoPin = new BancoPin();

	private Leitura l = new Leitura();

	private Pincel pin = new Pincel();

	private boolean vaiCodPin = true;

	public void menuPin(){

		boolean vaiPin = true;
		int opPin = 0;

		while(vaiPin){

			System.out.println("\n\t\t ===== Cadastro de pincel ====");
			System.out.println("\t\t==================================");

			System.out.println("\n\t (1) Inserir pincel");
			System.out.println("\t (2) Imprimir todos os pinceis");
			System.out.println("\t (3) Consultar pincel pelo codigo");
			System.out.println("\t (4) Alterar pincel pelo codigo");
			System.out.println("\t (5) Excluir pincel pelo codigo");
			System.out.println("\t (6) Voltar ao menu principal");

			try{
				opPin = Integer.parseInt(l.entDados("\nEscolha uma opcao: "));
			}
			catch(NumberFormatException nfe){
				l.entDados("\nA opcao de ser um numero inteiro - Pressione a tecla <Enter>");
				continue;
			}

			switch(opPin){
//========================================================================================================================
				case 1:
					pin = new Pincel();

					pin = bancoPin.cadPin(pin);

					bancoPin.getBDPin().add(pin);

					break;
//========================================================================================================================
				case 2:
					System.out.println("\nImprimir todos os pinceis - Pressione a tecla <Enter>");
					l.entDados("========================================================");

						for(int i = 0; i < bancoPin.getBDPin().size(); i++){
							bancoPin.impPin(bancoPin.getBDPin().get(i));
						}
								
					break;
//========================================================================================================================
				case 3:
					vaiCodPin = true;

					pin = new Pincel();

					while(vaiCodPin){
						try{
							pin.setCod(Integer.parseInt(l.entDados("\nCodigo a ser consultado: ")));
							vaiCodPin = false;
						}
						catch(NumberFormatException nfe){
							l.entDados("\n O código deve ser um valor inteiro - Pressione a tecla <Enter>");
							continue;
						}
					}

					pin = bancoPin.consPinCod(pin);

					if(pin == null){
						l.entDados("\n Não existe pincel com este codigo! - Pressione a tecla <Enter>");
					}
					else{
						bancoPin.impPin(pin);
					}

					break;
//========================================================================================================================
				case 4:
					vaiCodPin = true;

					pin = new Pincel();

					while(vaiCodPin){
						try{
							pin.setCod(Integer.parseInt(l.entDados("\nCodigo a ser alterado: ")));
							vaiCodPin = false;
						}
						catch(NumberFormatException nfe){
							l.entDados("\n O código deve ser um valor inteiro - Pressione a tecla <Enter>");
							continue;
						}
					}

					pin = bancoPin.alteraPin(pin);
					
					if(pin != null){
						l.entDados("\n Pincel alterado com sucesso. Pressione a tecla <Enter> para ver os novos dados!");
						bancoPin.impPin(pin);
					}
					else{
						l.entDados("\n Não existe Pincel com este codigo - Pressione a tecla <Enter>");
					}

					break;
//========================================================================================================================
				case 5:
					vaiCodPin = true;

					pin = new Pincel();

					while(vaiCodPin){
						try{
							pin.setCod(Integer.parseInt(l.entDados("\nCodigo a ser excluido: ")));
							vaiCodPin = false;
						}
						catch(NumberFormatException nfe){
							l.entDados("\n O código deve ser um valor inteiro - Pressione a tecla <Enter>");
							continue;
						}
					}

					pin = bancoPin.excluiPin(pin);
					
					if(pin != null){
						l.entDados("\n Pincel alterado com sucesso - Pressione a tecla <Enter>");
					}
					else{
						l.entDados("\n Não existe Pincel com este codigo - Pressione a tecla <Enter>");
					}

					break;
//========================================================================================================================
				case 6:
					vaiPin = false;

					break;
//========================================================================================================================
				default:
					l.entDados("\nDeve escolher valores entre 1 e 6 - Pressione a tecla <Enter>");

					break;
//========================================================================================================================
			}//fim do switch

		
		}//fim do while

	}//fim do menuPin()

}//fim

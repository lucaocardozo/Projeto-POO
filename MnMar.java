//Lucas Martins Cardozo - 1996770

public class MnMar{ 

	private BancoMar bancoMar = new BancoMar();

	private Leitura l = new Leitura();

	private MarcaTexto mar = new MarcaTexto();

	private boolean vaiCodMar = true;

	public void menuMar(){

		boolean vaiMar = true;
		int opMar = 0;

		while(vaiMar){

			System.out.println("\n\t\t ===== Cadastro de marca texto ====");
			System.out.println("\t\t==================================");

			System.out.println("\n\t (1) Inserir marca texto");
			System.out.println("\t (2) Imprimir todos os marca textos");
			System.out.println("\t (3) Consultar marca texto pelo codigo");
			System.out.println("\t (4) Alterar marca texto pelo codigo");
			System.out.println("\t (5) Excluir marca texto pelo codigo");
			System.out.println("\t (6) Voltar ao menu principal");

			try{
				opMar = Integer.parseInt(l.entDados("\nEscolha uma opcao: "));
			}
			catch(NumberFormatException nfe){
				l.entDados("\nA opcao de ser um numero inteiro - Pressione a tecla <Enter>");
				continue;
			}

			switch(opMar){
//========================================================================================================================

				case 1:
					mar = new MarcaTexto();

					mar = bancoMar.cadMar(mar);

					bancoMar.getBDMar().add(mar);

					break;
//========================================================================================================================

				case 2:
					System.out.println("\nImprimir todos os marca textos - Pressione a tecla <Enter>");
					l.entDados("========================================================");

						for(int i = 0; i < bancoMar.getBDMar().size(); i++){
							bancoMar.impMar(bancoMar.getBDMar().get(i));
						}
								
					break;
//========================================================================================================================

				case 3:
					vaiCodMar = true;

					mar = new MarcaTexto();

					while(vaiCodMar){
						try{
							mar.setCod(Integer.parseInt(l.entDados("\nCodigo a ser consultado: ")));
							vaiCodMar = false;
						}
						catch(NumberFormatException nfe){
							l.entDados("\n O código deve ser um valor inteiro - Pressione a tecla <Enter>");
							continue;
						}
					}

					mar = bancoMar.consMarCod(mar);

					if(mar == null){
						l.entDados("\n Não existe marca texto com este codigo! - Pressione a tecla <Enter>");
					}
					else{
						bancoMar.impMar(mar);
					}

					break;
//========================================================================================================================

				case 4:
					vaiCodMar = true;

					mar = new MarcaTexto();

					while(vaiCodMar){
						try{
							mar.setCod(Integer.parseInt(l.entDados("\nCodigo a ser alterado: ")));
							vaiCodMar = false;
						}
						catch(NumberFormatException nfe){
							l.entDados("\n O código deve ser um valor inteiro - Pressione a tecla <Enter>");
							continue;
						}
					}

					mar = bancoMar.alteraMar(mar);
					
					if(mar != null){
						l.entDados("\n Marca Texto alterado com sucesso. Pressione a tecla <Enter> para ver os novos dados!");
						bancoMar.impMar(mar);
					}
					else{
						l.entDados("\n Não existe Marca Texto com este codigo - Pressione a tecla <Enter>");
					}

					break;
//========================================================================================================================
				case 5:
					vaiCodMar = true;

					mar = new MarcaTexto();

					while(vaiCodMar){
						try{
							mar.setCod(Integer.parseInt(l.entDados("\nCodigo a ser excluido: ")));
							vaiCodMar = false;
						}
						catch(NumberFormatException nfe){
							l.entDados("\n O código deve ser um valor inteiro - Pressione a tecla <Enter>");
							continue;
						}
					}

					mar = bancoMar.excluiMar(mar);
					
					if(mar != null){
						l.entDados("\n Marca Texto alterado com sucesso - Pressione a tecla <Enter>");
					}
					else{
						l.entDados("\n Não existe Marca Texto com este codigo - Pressione a tecla <Enter>");
					}

					break;
//========================================================================================================================
				case 6:
					vaiMar = false;

					break;
//========================================================================================================================
				default:
					l.entDados("\nDeve escolher valores entre 1 e 6 - Pressione a tecla <Enter>");

					break;

//========================================================================================================================
			}//fim do switch

		
		}//fim do while

	}//fim do menuMar

}//fim
//Lucas Martins Cardozo - 1996770

public class TstSistema{

	private static MnMar mnMar = new MnMar();
	private static MnPin mnPin = new MnPin();
	private static Leitura l = new Leitura();

	public static void main(String arg[]){

		boolean vaiMnPrinc = true;
		int opMnPrinc = 0;

		while(vaiMnPrinc){
			System.out.println("\n\t\t Menu principal");
			System.out.println("\t\t==================================");

			System.out.println("\n\t (1) Menu de marca textos");
			System.out.println("\t (2) Menu de pinceis");
			System.out.println("\t (3) Sair");

			try{
				opMnPrinc = Integer.parseInt(l.entDados("\nEscolha uma opcao: "));
			}
			catch(NumberFormatException nfe){
				l.entDados("\nA opcao de ser um numero inteiro - Press <Enter>");
				continue;
			}

			switch(opMnPrinc){

//========================================================================================================================

				case 1:
					mnMar.menuMar();
					break;

//========================================================================================================================

				case 2:
					mnPin.menuPin();
					break;

//========================================================================================================================

				case 3:
					vaiMnPrinc = false;
					break;

//========================================================================================================================


				default:
					l.entDados("\nDeve escolher valores entre 1 e 3 - Pressione a tecla <Enter>");
					break;


			}//fim do switch
		
		}//fim do while
	}
}//fim
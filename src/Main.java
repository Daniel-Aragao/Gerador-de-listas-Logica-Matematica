import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {


	public static void main(String[] args) {
		String nome = null;
		nome = JOptionPane.showInputDialog("Nome: ");
		if(nome != null){

			int maxQuestoes = 10;

			ArrayList<String> questoes = ImportFormulas.getAll();

			String cabeçalho = nome + ImportFormulas.getTextFrom("res/cabeçalho.txt");

			String Folha = cabeçalho + "\r\n";

			Random randNumber = new Random();
			int[] alreadyCalled = new int[maxQuestoes];
			for(int i = 0 ; i < maxQuestoes; i++){

				int random = 0;

				do{
					random = randNumber.nextInt(questoes.size());

				}while(contains(alreadyCalled,random));

				alreadyCalled[i] = random;

				Folha +=(i+1)+". "+questoes.get(random) + "\r\n\r\n";
			}

			Folha += "\r\n"+ nome + ImportFormulas.getTextFrom("res/rodapé.txt");
	//		System.out.println(Folha);
			ExportFormulas.export(Folha, nome);
		}
	}

	public static boolean contains(int[] a, int element){

		for(int e : a){
			if(e == element){
				return true;
			}
		}

		return false;
	}


}

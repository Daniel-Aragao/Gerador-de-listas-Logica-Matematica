import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {


	public static void main(String[] args) {
		String resp = (String) JOptionPane.showInputDialog(null, "Nome: ", "", JOptionPane.PLAIN_MESSAGE,
				null, new Object[]{"Nome", "Lista"}, null);
		
		if(resp.equals("Nome")){
			String nome = JOptionPane.showInputDialog("Nome: ");
			gravarLista(nome);			
		}else{
			ArrayList<String> alunos = ImportFormulas.getAlunos("res/alunos.txt");
			for(String aluno : alunos){
				gravarLista(aluno);
			}
		}
		
	}
	
	private static void gravarLista(String nome){
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

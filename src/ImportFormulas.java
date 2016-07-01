import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ImportFormulas {
	private static int nQuestoes;
	private static int nAlunos = 0;

	public static ArrayList<String> getAll() {
		ArrayList<String> questoes = new ArrayList<String>();
		nQuestoes = 0;

		try {
			File fileDir = new File("res/Exercicios.txt");

			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "Unicode"));

			String line = "";
			while ((line = buffer.readLine()) != null) {
				questoes.add(line);
			}

			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		nQuestoes = questoes.size();

		return questoes;
	}

	public static int getNQuestoes() {
		return nQuestoes;
	}
	public static int getNAlunos() {
		return nAlunos;
	}
	public static String getTextFrom(String path) {
		String texto = "";

		try {
			File fileDir = new File(path);

			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "Unicode"));
			String line = "";
			while ((line = buffer.readLine()) != null) {
				texto += line + "%";
			}
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return texto;
	}

	public static ArrayList<String> getAlunos(String path) {
		ArrayList<String> alunos = new ArrayList<String>();
		nAlunos = 0;

		try {
			File fileDir = new File(path);

			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "Unicode"));

			String line = "";
			while ((line = buffer.readLine()) != null) {
				alunos.add(line);
			}

			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		nAlunos = alunos.size();

		return alunos; 
		
	}
}

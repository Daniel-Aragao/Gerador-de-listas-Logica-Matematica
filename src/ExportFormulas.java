import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ExportFormulas {

	public static void export(String texto, String nome){


		try {

			File fileDir = new File("listas/"+nome+".txt");

			Writer printer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(fileDir), "Unicode"));

			String [] linha = texto.split("%");
			for (int i = 0; i < linha.length; i++) {
				printer.append(linha[i]+"\r\n");
			}
//			printer.append(texto);


			printer.flush();
			printer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

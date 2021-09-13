import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextReader {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\RCHCHAN\\captmidn.txt");
		Scanner scan = new Scanner(file);

		String fileContent = "THIS IS A FILE MADE BY US \r\r";
		while (scan.hasNextLine()) {
			fileContent = fileContent.concat(scan.nextLine() + "\r\n\r\n"); // \r\n works fine in windows machine and \n
																			// works fine in macos
			//System.out.println(fileContent);
		}

		FileWriter writer = new FileWriter("C:\\Users\\RCHCHAN\\MyFile.txt");
		writer.write(fileContent);
		writer.close();
	}

}

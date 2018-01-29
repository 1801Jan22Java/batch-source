import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Testing {
	
	public static void main(String[] args) {
		File file = new File("test.txt");
		
		try {
			FileWriter fw = new FileWriter(file);
			
			fw.write("Hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

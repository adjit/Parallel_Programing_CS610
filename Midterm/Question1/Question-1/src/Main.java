
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int _NOTH = 13;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a line");
		String line = input.nextLine();
		input.close();
		
		MyThread[] thrds = new MyThread[_NOTH];
		
		int letter = 65;
		for(int i = 0; i < _NOTH; i++)
			thrds[i] = new MyThread((char)letter++, (char)letter++, line);
		
		try {
			for(int i = 0; i < _NOTH; i++) {
				thrds[i].start();
				thrds[i].join();
			}
		} catch(Exception e) {
			System.out.println("Error: " + e);
			System.exit(0);
		}
	}

}

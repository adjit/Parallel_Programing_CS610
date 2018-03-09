
public class MyThread extends Thread implements Runnable {

	private char a, b;
	private String line;
	private String upperLine;
	
	public MyThread(char a, char b, String line) {
		this.a = a;
		this.b = b;
		this.line = line;
		this.upperLine = line.toUpperCase();
	}
	
	public void run() {
		int counta = countOccurancesOf(a);
		int countb = countOccurancesOf(b);
		
		System.out.println(line + ": " + a + " is: " + counta);
		System.out.println(line + ": " + b + " is: " + countb);
	}
	
	private int countOccurancesOf(char letter) {
		int count = 0;
		letter = Character.toUpperCase(letter);
		
		for(int i = 0; i < upperLine.length(); i++)
			if(upperLine.charAt(i) == letter) count++;
		
		return count;
	}
}

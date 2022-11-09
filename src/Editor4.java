
public class Editor4 {
	public static void main (String[] args) {
		// Write your code here		
		int steps = Integer.parseInt(args[1]);
		Instush.morph(Instush.read(args[0]),Instush.greyscaled(Instush.read(args[0])), steps);
	}

}

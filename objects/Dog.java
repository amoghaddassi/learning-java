public class Dog {
	public int size;
	public String name;

	public Dog(int s, String n) {
		size = s;
		name = n;
	}

	public void makeNoise() {
		if (this.size < 10) {
			System.out.println("Yip!");
		} else if (size < 30) {
			System.out.println("Bark!");
		} else {
			System.out.println("Woof!");
		}
	}

	public static Dog maxDog(Dog d1, Dog d2) {
		if (d1.size > d2.size) {
			return d1;
		} else {return d2;}
	}
}
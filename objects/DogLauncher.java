public class DogLauncher {
	public static void main(String[] args) {
		Dog[] kennel = new Dog[2];
		kennel[0] = new Dog(20, "Rigby");
		kennel[1] = new Dog(50, "Charly");
		Dog bigger = Dog.maxDog(kennel[0], kennel[1]);
	}
}

/* Syntax notes about the object system

1. public className(attributes) will function as a class constructor for className

2. Declare new instances and bind them to variables by className instName = new className(constructor params)

3. className[] arrName = new className[x] will create an array of 
length x of className objects.

4. Methods that use instance variables are non-static. All other methods
should use the static keyword to denote that they will function the same for all
instances of a class. Static methods can be invoked using the class name, but instance
methods can't, and java will throw a non-static error. 
*/
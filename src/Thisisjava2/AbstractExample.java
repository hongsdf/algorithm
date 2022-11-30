package Thisisjava2;

public class AbstractExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.sound();
		
		Cat cat = new Cat();
		cat.sound();
		AnimalSound(new Cat());
		AnimalSound(new Dog());
		
		
	}
	public static void AnimalSound(Animal animal) { //animal자식클래스 dog,cat 들어갈 수 있다.
		animal.sound();
	}
}

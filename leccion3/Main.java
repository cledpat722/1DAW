package leccion3;

public class Main {

	public static void main(String[] args) {
		Animal animal = new Animal(new ImpAnimal());
		animal.getInsertaAnimal();
		animal.getEliminaAnimalByID(1);
	}
}

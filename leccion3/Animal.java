package leccion3;

public class Animal {

	InterfaceAnimal animal;
	
	public Animal(InterfaceAnimal animal) {
		this.animal = animal;
	}
	
	public void getInsertaAnimal() {
		animal.InsertaAnimal();
	}
	
	public void getEliminaAnimalByID(int id) {
		animal.EliminaAnimalByID(id);
		
	}
}

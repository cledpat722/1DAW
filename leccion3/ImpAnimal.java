package leccion3;

public class ImpAnimal implements InterfaceAnimal {

	@Override
	public void InsertaAnimal() {
		System.out.println("Insertando animal");
	}

	@Override
	public void EliminaAnimalByID(int id) {
		System.out.println("Eliminando animal: " + id);
	}

}

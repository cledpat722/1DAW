package instituto;

public class TemarioBD implements Temario {

	@Override
	public String getTemario() {
		return "El temario para este curso respecto a Base de Datos se coresponde al libro: Base de Datos Vol-1";
	}

	@Override
	public int getNumPag() {
		int numPag =  (int) Math.random()*150 +1;
		return numPag;
	}
		
}

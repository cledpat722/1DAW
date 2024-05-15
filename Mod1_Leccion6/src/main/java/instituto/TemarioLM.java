package instituto;

public class TemarioLM implements Temario{
	
	@Override
	public String getTemario() {
		return "El temario para este curso respecto a Lenguaje de marcas se coresponde al libro virtual: Lenguaje de marcas 1ª curso";
	}

	@Override
	public int getNumPag() {
		int numPag =  (int) Math.random()*200 +1;
		return numPag;
	}
}

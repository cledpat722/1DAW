package instituto;

public class TemarioProg implements Temario{

	@Override
	public String getTemario() {
		return "El temario para este curso de Programacion se coresponde al curso online: Programación Orientada a Objetos, aprende Java desde 0";
	}

	@Override
	public int getNumPag() {
		int numVideo =  (int) Math.random()*51;
		return numVideo;
	}
}

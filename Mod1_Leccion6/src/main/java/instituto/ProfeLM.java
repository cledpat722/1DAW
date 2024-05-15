package instituto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProfeLM implements Profesores {

	private Temario temario;

	@Autowired
	public ProfeLM(@Qualifier("temarioLM") Temario temarioLM) {
		this.temario= temarioLM;
	}

	@Override
	public String getTemario() {
		return this.temario.getTemario();
	}

	@Override
	public void mandarTarea() {
		int pagTarea = (int) (Math.random()* 200) + 1;
		System.out.println("Tarea LM: Ejercicios de la página: " + pagTarea);
	}

}

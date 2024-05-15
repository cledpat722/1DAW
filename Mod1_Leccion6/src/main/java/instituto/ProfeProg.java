package instituto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProfeProg implements Profesores {

	private Temario temario;

	@Autowired
	public ProfeProg(@Qualifier("temarioProg") Temario temarioProg) {
		this.temario = temarioProg;
	}

	@Override
	public String getTemario() {
		return this.temario.getTemario();
	}

	@Override
	public void mandarTarea() {
		int pagTarea = (int) (Math.random() * 30) + 1;
		System.out.println("Tarea Prog: Ejercicios de la página: " + pagTarea);
	}

}

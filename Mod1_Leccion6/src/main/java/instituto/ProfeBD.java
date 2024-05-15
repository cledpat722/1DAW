package instituto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProfeBD implements Profesores {

	
	private Temario temario;
	
	
	@Autowired
	public ProfeBD(@Qualifier("temarioBD") Temario temarioBD) {
		this.temario = temarioBD;
	}

	@Override
	public String getTemario() {
		return this.temario.getTemario();
	}

	@Override
	public void mandarTarea() {
		int pagTarea = (int) (Math.random()* 100) +1;
		System.out.println("Tarea BD: Ejercicios de la página: " + pagTarea);
	}

}

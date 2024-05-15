package instituto;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstitutoMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationsContext.xml");
		
		Profesores pepe = context.getBean("profeBD", Profesores.class);
		
		Profesores juan = context.getBean("profeProg", Profesores.class);
		
		Profesores alfredo = context.getBean("profeLM", Profesores.class);
		
		System.out.println("\n---------------TEMARIOS---------------");
		System.out.println(pepe.getTemario());
		System.out.println(juan.getTemario());
		System.out.println(alfredo.getTemario());
		
		System.out.println("\n----------------TAREAS----------------");
		pepe.mandarTarea();
		juan.mandarTarea();
		alfredo.mandarTarea();
		
		context.close();
	}

}

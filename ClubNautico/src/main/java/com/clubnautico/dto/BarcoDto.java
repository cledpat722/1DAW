package com.clubnautico.dto;

public class BarcoDto {

		private String matricula;
		private String nombre;
		private int numAmarre;
		private float cuota;
		
		public String getMatricula() {
			return matricula;
		}
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getNumAmarre() {
			return numAmarre;
		}
		public void setNumAmarre(int numAmarre) {
			this.numAmarre = numAmarre;
		}
		public float getCuota() {
			return cuota;
		}
		public void setCuota(float cuota) {
			this.cuota = cuota;
		}
		public BarcoDto() {
		}
}

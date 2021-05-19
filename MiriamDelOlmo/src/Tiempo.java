
public class Tiempo {

	private String ciudad, tiempo;
	private int dia, mes, a�o, probLluvia, tempMin, tempMax, velocidad;
	
	public Tiempo(String ciudad, int dia, int mes, int a�o, String tiempo, int probLluvia, int tempMin, int tempMax, int velocidad) {
		this.ciudad = ciudad;
		this.tiempo = tiempo;
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
		this.probLluvia = probLluvia;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.velocidad = velocidad;
	}
	


	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public int getProbLluvia() {
		return probLluvia;
	}

	public void setProbLluvia(int probLluvia) {
		this.probLluvia = probLluvia;
	}

	public int getTempMin() {
		return tempMin;
	}

	public void setTempMin(int tempMin) {
		this.tempMin = tempMin;
	}

	public int getTempMax() {
		return tempMax;
	}

	public void setTempMax(int tempMax) {
		this.tempMax = tempMax;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}



	@Override
	public String toString() {
		return "Tiempo [ciudad=" + ciudad + ", tiempo=" + tiempo + ", dia=" + dia + ", mes=" + mes + ", a�o=" + a�o
				+ ", probLluvia=" + probLluvia + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", velocidad="
				+ velocidad + "]";
	}



}

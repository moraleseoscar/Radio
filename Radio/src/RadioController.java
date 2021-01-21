import java.util.ArrayList;

/**
 * @author Oscar Estrada y Lorena Beltran
 *
 */
public class RadioController implements InterfaceRadio{

	private boolean power;
	private String frecuencia;
	private double emisora_seleccionada;
	private ArrayList<Double> emisoras;

	/**
	 * @param power
	 * @param frecuencia
	 * @param emisora_seleccionada
	 * @param emisoras
	 */
	public RadioController() {
		this.power = false;
		this.frecuencia = "AM";
		this.emisora_seleccionada = 1070;
		this.emisoras = new ArrayList<Double>();
		for(int i=0;i<12;i++)
		{
		    emisoras.add(0.00);
		}
	}

	@Override
	public void encender() {
		// TODO Auto-generated method stub
		power = !power;
	}

	@Override
	public String cambiar_emisora(boolean cambio) {
		// TODO Auto-generated method stub
		String cadena = "Reproduciendo ";
		double posicion = emisora_seleccionada;
		if(frecuencia == "AM") {
			if(cambio) {
				posicion = (posicion == 1610)?530:posicion +10;
			}else {
				posicion = (posicion == 530)?1610:posicion -10;
			}
		}else {
			if(cambio) {
				posicion = (posicion == 107.9)?87.9:posicion +0.2;
			}else {
				posicion = (posicion == 87.9)?107.9:posicion -0.2;
			}
		}
		emisora_seleccionada = posicion;
		cadena = cadena + emisora_seleccionada + " " + frecuencia + "...";
		return cadena;
	}

	@Override
	public void cambiar_frecuencia() {
		// TODO Auto-generated method stub
		if(frecuencia == "AM") {
			frecuencia = "FM";
			emisora_seleccionada = 97.9;
		}else {
			frecuencia = "AM";
			emisora_seleccionada = 1070;
		}
	}

	@Override
	public boolean obtenerPoder() {
		return power;
	}

	@Override
	public void guardar_emisora(double nueva_emisora, int posicion) {
		// TODO Auto-generated method stub
		emisoras.set(posicion, nueva_emisora);
	}

	@Override
	public String obtenerEmisoras() {
		// TODO Auto-generated method stub
		String cadena = "Listado de emisoras guardadas:\n=====================================================\n\n";
		int posicion = 0;
		for(double em:emisoras) {
			posicion+=1;
			if(em == 0){
				cadena = cadena + posicion + ".) \n";
			}else if(em-(int)em==0) {
				cadena = cadena + posicion + ".) "+ em + " AM\n";
			}else {
				cadena = cadena + posicion + ".) "+ em + " FM\n";
			}

		}
		return cadena;
	}

	@Override
	public String seleccionar_guardada(int posicion) {
		// TODO Auto-generated method stub
		String cadena = "Reproduciendo ";
		if(emisoras.get(posicion) == 0) {
			cadena = "Parece que no tienes una emisora en ese espacio.";
		}else {
			emisora_seleccionada = emisoras.get(posicion);
			cadena = cadena + emisora_seleccionada + " " + frecuencia + "... ";
		}
		return cadena;
	}

	@Override
	public String toString() {
		return "RadioController [power=" + power + ", frecuencia=" + frecuencia + ", emisora_seleccionada="
				+ emisora_seleccionada + ", emisoras=" + emisoras + "]";
	}
}
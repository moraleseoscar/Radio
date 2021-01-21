/**
 * @author Oscar Estrada y Lorena Beltrán
 *
 */
public interface InterfaceRadio {
	public void  encender(); //apagado - false
	
	public boolean obtenerPoder();
	
	public String cambiar_emisora(boolean cambio);
	
	public void cambiar_frecuencia(); // bloqueado - false
	
	public void guardar_emisora(double nueva_emisora, int posicion);
	
	public String seleccionar_guardada(int posicion);
	
	public String obtenerEmisoras();

}

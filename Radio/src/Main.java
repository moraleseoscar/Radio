import java.util.Scanner;

/**
 * @author Oscar Estrada y Lorena Beltran
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceRadio radio = new RadioController();
		Scanner sc = new Scanner(System.in);
		
		boolean menu = true;

        while(menu) {
        	String estado = (radio.obtenerPoder())?"Encendido":"Apagado";
        	System.out.println("");
        	System.out.println("+----------------------------------+");
            System.out.println("|          Simulacion iPod         |");
            System.out.println("+----------------------------------+");
            System.out.println("");
            System.out.println("Estado de radio: "  + estado);
            System.out.println("");
            System.out.println("1. Encender/Apagar.");
            System.out.println("2. Cambiar frecuencia (AM/FM).");
            System.out.println("3. Avanzar dial de emisora.");
            System.out.println("4. Guardar emisora.");
            System.out.println("5. Reproducir emisora favorita.");
            System.out.println("0. Salir.");
            System.out.println("");
            System.out.print("Seleccione el numero de la accion que desea realizar: ");
            int sel = sc.nextInt();
            sc.nextLine();
            while(sel < 0 || sel > 5) {
            	System.out.print("Seleccion fuera de rango. Intente de nuevo:");
                sel = sc.nextInt();
                sc.nextLine();
    		}
            System.out.println("");
            if(sel == 0) {
            	menu = false;
            	System.out.println("...");
            }else if(sel==1) {
            	radio.encender();
        		System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }else if(sel==2) {
            	if(radio.obtenerPoder()) {
            		radio.cambiar_frecuencia();
            	}else {
            		System.out.println("Radio apagada");
            	}
            	System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }else if(sel==3) {
            	if(radio.obtenerPoder()) {
            		boolean escoger = true;
                	while(escoger) {
	            		System.out.print("Elija para donde quiere ir (1. Adelante / 0. Atras): ");
	                    String cam = sc.nextLine();
	                    if(cam.equals("1")) {
	                    	System.out.println(radio.cambiar_emisora(true));
	                    }else {
	                    	System.out.println(radio.cambiar_emisora(false));
	                    }
	                    System.out.print("�Desea cambiar otra vez de emisora?(1. Si / 0. No): ");
	                    String ch = sc.nextLine();
	                    if(!ch.equals("1")) {
	                    	escoger = false;
	                    }
                	}
            	}else {
            		System.out.println("Radio apagada");
            	}
            	System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }else if(sel==4) {
            	if(radio.obtenerPoder()) {
            		
                    System.out.print("Elija que frecuencia es (1. AM / 0. FM): ");
                    String cam = sc.nextLine();
                    
                    System.out.print("Ingrese el numero de la emisora que desee guardar: ");
                    double vo = sc.nextDouble();
                    sc.nextLine();
                    boolean completo = true;             
                    if(cam.equals("1")) {
                    	while(completo){
                    		while(vo < 530 || vo > 1610) {
                            	System.out.print("Seleccion fuera de rango. Intente de nuevo:");
                            	vo = sc.nextDouble();
                                sc.nextLine();
                    		}
                    		if(vo-(int)vo==0 && vo % 10 == 0) {
                				completo = false;
                			}else {
                				System.out.print("Parece que eso no es una emisora AM. Intente de nuevo:");
                			}
                    	}
                    }else {
                    	while(completo){
                    		while(vo < 87.9 || vo > 107.9) {
                            	System.out.print("Seleccion fuera de rango. Intente de nuevo:");
                            	vo = sc.nextDouble();
                                sc.nextLine();
                    		}
                    		if(vo-(int)vo!=0 && (vo-(int)vo==1 || vo-(int)vo==3 || vo-(int)vo==7 || vo-(int)vo==9)) {
                				completo = false;
                			}else {
                				System.out.print("Parece que eso no es una emisora FM. Intente de nuevo:");
                			}
                    	}
                    }
                    System.out.print("Ingrese en que posicion quiere colocarlo: ");
                    int po = sc.nextInt();
                    sc.nextLine();
                    po -= 1;
                    while(po < 0 || po > 12) {
                    	System.out.print("Seleccion fuera de rango. Intente de nuevo:");
                    	po = sc.nextInt();
                        sc.nextLine();
            		}
                    radio.guardar_emisora(vo, po);
            	}else {
            		System.out.println("Radio apagada");
            	}
            	System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }else if(sel==5) {
            	if(radio.obtenerPoder()) {
            		System.out.println(radio.obtenerEmisoras());
            		System.out.print("Ingrese el numero de emisora que desea reproducir: ");
                    int po = sc.nextInt();
                    sc.nextLine();
                    po -= 1;
                    while(po < 0 || po > 12) {
	                    System.out.print("Seleccion fuera de rango. Intente de nuevo:");
	                    po = sc.nextInt();
	                    sc.nextLine();
             		}
                    System.out.println(radio.seleccionar_guardada(po));
            	}else {
            		System.out.println("Radio apagada");
            	}
            	System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }
        }
	}

}
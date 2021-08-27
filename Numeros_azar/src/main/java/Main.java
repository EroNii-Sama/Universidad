import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Main {
    private static String[] lista;
    private static String[] listaI;
    private static long max = 10000000;
    private static long min = 1000;
    private static long tamano = 0;
    private final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        long limit = (long) (Math.random() * 4) + 1;
        lista = Generador(limit).split("-");
        listaI = Despues(lista);
        Validacion(lista, listaI);
        System.out.println(Arrays.toString(lista));
        System.out.println(Arrays.toString(listaI));
    }

    public static String Generador(long limit) {
        long numbers = 0;
        String sNumber = "";
        logger.debug("Generando contenido del array lista");
        for (int i = 0; (long) i < limit; ++i) {
            numbers = (long) (Math.random() * max) + min;
            sNumber += numbers + "-";
        }
        return sNumber;
    }

    public static String[] Despues(String[] cadena) {
        String[] listaT = new String[cadena.length];
        int contador = 0;
        logger.debug("Invirtiendo contenido del array lista");
        logger.info("El contenido invertido se usa en el array listaI");
        for (int i = cadena.length - 1; i >= 0; --i) {
            listaT[contador] = cadena[i];
            contador++;
        }
        tamano = cadena.length;
        return listaT;
    }

    public static void Validacion(String[] arrayO, String[] arrayT) {
        boolean validar = false;
        int comparar = (int) tamano - 1;
        for (int i = 0; i < tamano - 1; ++i) {
            if (!arrayO[i].equals(arrayT[comparar])) {
                logger.debug("Se realiza comparacion de arrays");
                validar = true;
                break;
            }
            comparar--;
        }
        if (validar == false) {
            logger.debug("La cadena de numeros a sido invertida satisfactoriamente");
        } else {
            logger.error("La cadena de numeros no fue invertida satisfactoriamente");
            logger.info("La cadena de numeros comparada pudo no haber sido la misma o hubo un error en el proceso");
        }
    }
}

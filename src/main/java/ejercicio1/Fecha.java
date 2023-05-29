package ejercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
    public String nextDay(int dia, int mes, int anio) {
        if(dia>0 && mes>0) {
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            fecha = fecha.plusDays(1); // Obtener el día siguiente

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaTexto = fecha.format(formato);
            return fechaTexto;
        }else{
            return "Coloca una fecha correcta";
        }

    }
}

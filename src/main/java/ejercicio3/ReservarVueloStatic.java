package ejercicio3;

import ejercicio2.ReservarVueloService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ReservarVueloStatic {
    private ReservarVueloServiceStatic serviceStatic;
    public ReservarVueloStatic(){
        serviceStatic = new ReservarVueloServiceStatic();
    }

    public ReservarVueloStatic(ReservarVueloServiceStatic serviceStatic){
        this.serviceStatic = serviceStatic;
    }
    public String reservarVuelo(String destino, int cantidad, int dia, int mes, int anio){
        boolean siHayPasajes = serviceStatic.existenPasajes(destino,cantidad);
        if(siHayPasajes){
            String diaNombre = serviceStatic.getDay(dia,mes,anio);
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.getDefault());
            String nombreFecha = fecha.format(formatter);
            return "el dia " + diaNombre +" " + nombreFecha + " existen " + cantidad + " pasajes para " + destino;
        }else{
            return "no existen suficientes pasajes para " + destino;
        }
    }
}

package ejercicio3;

import ejercicio2.ReservarVueloService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ReservarVueloStatic {
    private ReservarVueloService service;
    public ReservarVueloStatic(){
        service = new ReservarVueloService();
    }

    public void setService(ReservarVueloService service){
        this.service = service;
    }
    public String reservarVuelo(String destino, int cantidad, int dia, int mes, int anio){
        boolean siHayPasajes = service.existenPasajes(destino,cantidad);
        if(siHayPasajes){
            String diaNombre = service.getDay(dia,mes,anio);
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.getDefault());
            String nombreFecha = fecha.format(formatter);
            return "el dia " + diaNombre +" " + nombreFecha + " existen " + cantidad + " pasajes para " + destino;
        }else{
            return "no existen suficientes pasajes para " + destino;
        }
    }
}

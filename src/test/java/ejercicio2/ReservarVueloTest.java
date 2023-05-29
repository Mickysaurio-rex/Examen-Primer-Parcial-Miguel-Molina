package ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class ReservarVueloTest {
    ReservarVueloService serviceMock = Mockito.mock(ReservarVueloService.class);

    @ParameterizedTest
    @CsvSource({
            "La Paz,2,29,05,2023,el dia Lunes 29 mayo 2023 existen 2 pasajes para La Paz"
    })

    public void veryfyFactorial(String destino, int cantidad, int dia, int mes, int anio, String expectedResult){
        Mockito.when(serviceMock.existenPasajes("La Paz",2)).thenReturn(true);
        Mockito.when(serviceMock.existenPasajes("Cochabamba",3)).thenReturn(true);
        Mockito.when(serviceMock.existenPasajes("Oruro",2)).thenReturn(true);
        Mockito.when(serviceMock.existenPasajes("Tarija",100)).thenReturn(false);

        Mockito.when(serviceMock.getDay(29,05,2023)).thenReturn("Lunes");
        Mockito.when(serviceMock.getDay(18,05,2023)).thenReturn("Jueves");
        Mockito.when(serviceMock.getDay(12,05,2023)).thenReturn("Viernes");

        ReservarVuelo reservarVuelo = new ReservarVuelo();
        reservarVuelo.setService(serviceMock);
        String actualResult = reservarVuelo.reservarVuelo(destino,cantidad,dia,mes,anio);
        Assertions.assertEquals(expectedResult,actualResult,"Error!");

    }
}

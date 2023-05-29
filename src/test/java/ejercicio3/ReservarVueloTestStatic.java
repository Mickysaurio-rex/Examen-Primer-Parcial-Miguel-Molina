package ejercicio3;

import ejercicio2.ReservarVuelo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ReservarVueloTestStatic {
    @BeforeAll
    public static void beforeClass(){
        MockedStatic<ReservarVueloServiceStatic> overrideReservarVueloServiceStatic = Mockito.mockStatic(ReservarVueloServiceStatic.class);

        overrideReservarVueloServiceStatic.when(()->ReservarVueloServiceStatic.existenPasajes("La Paz",2)).thenReturn(true);
        overrideReservarVueloServiceStatic.when(()->ReservarVueloServiceStatic.existenPasajes("Cochabamba",3)).thenReturn(true);
        overrideReservarVueloServiceStatic.when(()->ReservarVueloServiceStatic.existenPasajes("Tarija",100)).thenReturn(false);

        overrideReservarVueloServiceStatic.when(()->ReservarVueloServiceStatic.getDay(29,05,2023)).thenReturn("Lunes");
        overrideReservarVueloServiceStatic.when(()->ReservarVueloServiceStatic.getDay(18,05,2023)).thenReturn("Jueves");
        overrideReservarVueloServiceStatic.when(()->ReservarVueloServiceStatic.getDay(12,05,2023)).thenReturn("Viernes");
    }

    @ParameterizedTest
    @CsvSource({
            "La Paz,2,29,05,2023,el dia Lunes 29 mayo 2023 existen 2 pasajes para La Paz"
    })

    public void verifyReservarVueloStatic(String destino, int cantidad,int dia, int mes, int anio, String expectedResult){
        ReservarVueloStatic reservarVueloStatic = new ReservarVueloStatic();
        String actualResult = reservarVueloStatic.reservarVuelo(destino,cantidad,dia,mes,anio);
        Assertions.assertEquals(expectedResult,actualResult,"Error!");
    }

}

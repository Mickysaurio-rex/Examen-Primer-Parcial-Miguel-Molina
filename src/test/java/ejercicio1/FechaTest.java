package ejercicio1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FechaTest {
    Fecha fecha = new Fecha();
    @ParameterizedTest
    @CsvSource(
            {
                    "01,01,2023,02/01/2023",
                    "31,12,2023,01/01/2024",
                    "00,01,2023,Coloca una fecha correcta",
            }
            )
    public void verifynextDay(int dia, int mes, int anio, String expectedResult){
        String actualResutl = fecha.nextDay(dia,mes,anio);
        Assertions.assertEquals(expectedResult,actualResutl,"ERROR! la fecha que ingreso no es valida");
    }

}

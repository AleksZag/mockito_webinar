import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Set;

class AdviceServiceTest {

//    @Test
//    void test_get_advice_in_bad_weather() {
//        WeatherService weatherService = Mockito.mock(WeatherService.class);
//
//        Mockito.when(weatherService.currentWeather())
//                .thenReturn(Weather.STORMY);
//
//        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);
//        Mockito.when(preferencesService.get(Mockito.anyString()))
//                .thenReturn(Set.of(Preference.FOOTBALL, Preference.WATCHING_FILMS, Preference.READING));
//
//        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
//        Set<Preference> preferences = adviceService.getAdvice("user1");
//        Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);
//        Assertions.assertEquals(expected, preferences);
//    }
//    @Test
//    void test_get_advice_in_bad_weather() {
//        WeatherService weatherService = Mockito.mock(WeatherService.class);
//        Mockito.when(weatherService.currentWeather()).thenReturn(Weather.STORMY);
//        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);
//        Mockito.when(preferencesService.get(Mockito.any())).thenReturn(Set.of(Preference.FOOTBALL));
//        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
//        adviceService.getAdvice("user1");
//        Mockito.verify(preferencesService, Mockito.atLeast(1)).get("user1");
//        Mockito.verify(preferencesService, Mockito.never()).get("user2");
//    }

    @Test
    void test_get_advice_in_bad_weather() {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        Mockito.when(weatherService.currentWeather()).thenReturn(Weather.STORMY);
        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);

        Mockito.when(preferencesService.get(Mockito.any())).thenReturn(Set.of(Preference.FOOTBALL))
        ;
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
        adviceService.getAdvice("user2");
        Mockito.verify(preferencesService).get(argumentCaptor.capture());
        Assertions.assertEquals("user2", argumentCaptor.getValue());
    }



    @Test
    void test_spy_weather_service() {
        WeatherService weatherService = Mockito.spy(WeatherServiceImpl.class);
        Mockito.when(weatherService.currentWeather())
                .thenReturn(Weather.SUNNY);
        Assertions.assertEquals(Weather.SUNNY, weatherService.currentWeather());
    }



}

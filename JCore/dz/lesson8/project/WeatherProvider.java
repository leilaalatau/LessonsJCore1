package lessonsJCore.JCore.dz.lesson8.project;

import lessonsJCore.JCore.dz.lesson7.project.enums.Periods;
import lessonsJCore.JCore.dz.lesson8.project.entity.WeatherData;

import java.io.IOException;

public interface WeatherProvider {
    WeatherData getWeather(Periods periods) throws IOException;

    WeatherData getAllFromDb() throws IOException;
}

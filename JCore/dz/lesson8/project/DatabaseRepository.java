package lessonsJCore.JCore.dz.lesson8.project;

import lessonsJCore.JCore.dz.lesson8.project.entity.WeatherData;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseRepository {

        boolean saveWeatherData(WeatherData weatherData) throws SQLException;

        List<WeatherData> getAllSavedData() throws IOException;
}

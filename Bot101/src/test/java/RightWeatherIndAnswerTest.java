import advisor.ClothChooser;
import commands.JsonParserResult;
import commands.WeatherIndCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RightWeatherIndAnswerTest {
    @Test
    void getRightWeatherIndAnswer() {
        var testsConstants = new Constants();
        var jsonWeather = testsConstants.IndRequestAnswer;
        var parserResult = new JsonParserResult("4.62", "1017.0", "75.0","Clouds", "04d", "4.0").FormParserOutput();
        assertEquals(parserResult.stringOutput,
                WeatherIndCommand.JSONParser(jsonWeather).FormParserOutput().stringOutput);
        assertEquals(parserResult.recommendation,
                WeatherIndCommand.JSONParser(jsonWeather).FormParserOutput().recommendation);
        var cloth = new ClothChooser(4.62, "04", 4.0, "Clouds");
        assertEquals(cloth.body, "Куртка");
        assertEquals(cloth.legs, "Джинсы");
        assertEquals(cloth.head, "Шапка");
        assertEquals(cloth.feets, "Ботинки");
    }
}

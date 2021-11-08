package commands;

import org.json.JSONObject;

public class WeatherIndCommand implements BotCommand {
    @Override
    public String returnAnswer(String input) {
        return printAboutWeather(input.split(" ")[1], input.split(" ")[2]);
    }

    private static String printAboutWeather(String ind, String countryCode) {
        var result = JSONParser(api.WeatherAPI.GetContentInd(ind, countryCode));
        return result.FormOutput();
    }

    public static JsonParserResult JSONParser(String inputResult) {
        var jsonObj = new JSONObject(inputResult);
        var temp = ("" + jsonObj.getJSONObject("main").getDouble("temp"));

        var tempMax = ("" + jsonObj.getJSONObject("main").getDouble("temp_max"));
        var tempMin = ("" + jsonObj.getJSONObject("main").getDouble("temp_min"));
        var pressure = ("" + jsonObj.getJSONObject("main").getDouble("pressure"));
        var clouds = ("" + jsonObj.getJSONObject("clouds").getDouble("all"));
        var icon = ("" + jsonObj.getJSONArray("weather").getJSONObject(0).getString("icon"));
        return new JsonParserResult(temp, pressure, clouds, icon);
    }
}
package commands;

import org.json.JSONObject;

public class WeatherIdCommand implements BotCommand {
    @Override
    public String returnAnswer(String input) {
        return printAboutWeather(input.split(" ")[1]);
    }

    private static String printAboutWeather(String id) {
        var result = JSONParser(api.WeatherAPI.GetContentId(id));
        return result.FormOutput();
    }

    public static JsonParserResult JSONParser(String inputResult) {
        var jsonObj = new JSONObject(inputResult);
        var temp = ("" + jsonObj.getJSONObject("main").getDouble("temp"));
        var pressure = ("" + jsonObj.getJSONObject("main").getDouble("pressure"));
        var clouds = ("" + jsonObj.getJSONObject("clouds").getDouble("all"));
        var icon = ("" + jsonObj.getJSONArray("weather").getJSONObject(0).getString("icon"));
        return new JsonParserResult(temp, pressure, clouds, icon);
    }
}
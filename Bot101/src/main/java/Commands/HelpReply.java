package commands;

public class HelpReply implements DialogAnswer {
    @Override
    public String getContent() {
        return "Привет, я робот! Я умею рассказать о себе по комманде /about, " +
                "а еще могу вернуть погоду, для этого введи /weather" +
                " пожалуйста, указывайте город английскими буквами" +
                " ещё я могу узнать погоду в твоем городе по id твоего города, используй /weatherId," +
                " могу также узанть погоду по координатам через /weatherCord, также могу дать более детальный совет," +
                "для этого воспользуйся одной из кнопок для клавиатуры. " +
                "Ну а если тебе нужен быстрый результат, скинь свою геоокацию в чат со мной," +
                "я выведу погоду по твоему местоположению)";
    }
}
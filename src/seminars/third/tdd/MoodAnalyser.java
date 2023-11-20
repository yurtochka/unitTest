package seminars.third.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.contains("bad")) {
            return "SadVerysad";
        } else if (message.contains("happy")) {
            return "GoodVeryGood";
        }
        return "So so";
    }

}
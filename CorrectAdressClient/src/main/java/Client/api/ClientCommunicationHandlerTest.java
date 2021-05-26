package Client.api;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ClientCommunicationHandlerTest {
    private static JSONObject test1;
    private static JSONObject test2;
    private static JSONObject test3;
    private static JSONObject test4;
    private static JSONObject test5;

    @BeforeAll()
    static void createObjects() {
        test1 = new JSONObject();
        test2 = new JSONObject();
        test3 = new JSONObject();
        test4 = new JSONObject();
        test5 = new JSONObject();

        test1.append("country", "United States");
        test1.append("state", "Kentucky");
        test1.append("city", "Alexandria");

        test2.append("country", "United Kingdom");
        test2.append("state", "West Dunbartonshire");
        test2.append("city", "Alexandria");

        test3.append("country", "Egypt");
        test3.append("state", "Al Iskandar?yah");
        test3.append("city", "Alexandria");

        test4.append("country", "United States");
        test4.append("state", "Louisiana");
        test4.append("city", "Alexandria");

        test5.append("country", "Romania");
        test5.append("state", "Suceava");
        test5.append("city", "Vicovu de Sus");
    }

    @Test
    void test1() {
        JSONObject result = ClientCommunicationHandler.getAdress("Alexandria", "", "United States");
        Assertions.assertEquals(test1.toString(),
                "{" +
                        "\"country\":" + "[\"" + result.get("country") + "\"]," +
                        "\"city\":" + "[\"" + result.get("city") + "\"]," +
                        "\"state\":" + "[\"" + result.get("state") + "\"]" +
                       "}");
    }

    @Test
    void test2() {
        JSONObject result = ClientCommunicationHandler.getAdress("Alexandria", "", "United Kingdom");
        Assertions.assertEquals(test2.toString(),
                "{" +
                        "\"country\":" + "[\"" + result.get("country") + "\"]," +
                        "\"city\":" + "[\"" + result.get("city") + "\"]," +
                        "\"state\":" + "[\"" + result.get("state") + "\"]" +
                        "}");
    }

    @Test
    void test3() {
        JSONObject result = ClientCommunicationHandler.getAdress("Alexandria", "", "Egypt");
        Assertions.assertEquals(test3.toString(),
                "{" +
                        "\"country\":" + "[\"" + result.get("country") + "\"]," +
                        "\"city\":" + "[\"" + result.get("city") + "\"]," +
                        "\"state\":" + "[\"" + result.get("state") + "\"]" +
                        "}");
    }

    @Test
    void test4() {
        JSONObject result = ClientCommunicationHandler.getAdress("Alexandria", "Louisiana", "");
        Assertions.assertEquals(test4.toString(),
                "{" +
                        "\"country\":" + "[\"" + result.get("country") + "\"]," +
                        "\"city\":" + "[\"" + result.get("city") + "\"]," +
                        "\"state\":" + "[\"" + result.get("state") + "\"]" +
                        "}");
    }

    @Test
    void test5() {
        JSONObject result = ClientCommunicationHandler.getAdress("Alexandria", "Kentucky", "");
        Assertions.assertEquals(test1.toString(),
                "{" +
                        "\"country\":" + "[\"" + result.get("country") + "\"]," +
                        "\"city\":" + "[\"" + result.get("city") + "\"]," +
                        "\"state\":" + "[\"" + result.get("state") + "\"]" +
                        "}");
    }

    @Test
    void test6() {
        JSONObject result = ClientCommunicationHandler.getAdress("Vicovu de Sus", "", "");
        Assertions.assertEquals(test5.toString(),
                "{" +
                        "\"country\":" + "[\"" + result.get("country") + "\"]," +
                        "\"city\":" + "[\"" + result.get("city") + "\"]," +
                        "\"state\":" + "[\"" + result.get("state") + "\"]" +
                        "}");
    }

    @Test
    void test7() {
        JSONObject result = ClientCommunicationHandler.getAdress("Vicovu de Sus", "Bucharest", "Egypt");
        Assertions.assertEquals(test5.toString(),
                "{" +
                        "\"country\":" + "[\"" + result.get("country") + "\"]," +
                        "\"city\":" + "[\"" + result.get("city") + "\"]," +
                        "\"state\":" + "[\"" + result.get("state") + "\"]" +
                        "}");
    }
}
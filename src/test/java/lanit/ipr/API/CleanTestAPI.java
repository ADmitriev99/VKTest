package lanit.ipr.API;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lanit.ipr.PropertiesTest;


public class CleanTestAPI extends PropertiesTest {

    public static void CleanStepAPI(){
        RequestSpecification request = RestAssured.given();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        request.post(properties.getProperty("baseURI")+ "photos.delete?photo_id="+ properties.getProperty("mainPhotoId")+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "account.saveProfileInfo?" + "relation=0&" + "country_id=0&" + "city_id=0&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.post(properties.getProperty("baseURI")+ "messages.deleteConversation?peer_id=" + properties.getProperty("chatId") + "&"+ properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ " groups.leave?group_id=" + properties.getProperty("groupId") + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "photos.deleteAlbum?album_id=" + properties.getProperty("albumId") + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
    }
}

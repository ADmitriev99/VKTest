package lanit.ipr.API;

import lanit.ipr.PropertiesSingleton;

import java.util.Properties;

import static lanit.ipr.actions.ResponseClass.postRequest;


public class CleanAPI {

    protected static Properties properties = PropertiesSingleton.getInstance();

    public static void CleanStepAPI() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        postRequest("photos.delete?photo_id=" + properties.getProperty("mainPhotoId") + "&");
        postRequest("account.saveProfileInfo?" + "relation=0&" + "country_id=0&" + "city_id=0&");
        postRequest("messages.deleteConversation?peer_id=" + properties.getProperty("chatId") + "&");
        int chat = Integer.parseInt(properties.getProperty("chatId")) + 1;
        postRequest("messages.deleteConversation?peer_id=" + chat + "&");
        postRequest("groups.leave?group_id=" + properties.getProperty("groupId") + "&");
        postRequest("photos.deleteAlbum?album_id=" + properties.getProperty("albumId") + "&");
    }
}

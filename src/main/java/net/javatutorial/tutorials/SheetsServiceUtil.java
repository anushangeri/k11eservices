package net.javatutorial.tutorials;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

public class SheetsServiceUtil {

    private static final String APPLICATION_NAME = "sembcorp test (Responses)";

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
    	System.out.println("came sheetservuceutil");
        Credential credential = GoogleAuthorizeUtil.authorize();
        System.out.println("credential" + credential.toString());
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
    }

}
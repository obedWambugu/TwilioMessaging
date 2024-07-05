package org.example;

// Install the Java helper library from twilio.com/docs/java/install

//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//public class Main{
//    // Find your Account SID and Auth Token at twilio.com/console
//    // and set the environment variables. See http://twil.io/secure
//    public static final String ACCOUNT_SID = "ACae3eef3bb9f4972aef8eb44930840b60";
//    public static final String AUTH_TOKEN = "d6be2b135661d3aef91a1d114922c962";
//
//    public static void main(String[] args) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                        new com.twilio.type.PhoneNumber("+254748171214"),
//                        new com.twilio.type.PhoneNumber("+16144728436"),
//                        "Hi there")
//                .create();
//
//        System.out.println(message);
//
//        System.out.println(message.getSid());
//    }
//}

// Install the Java helper library from twilio.com/docs/java/install
//
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//
//public class Main {
//    // Find your Account SID and Auth Token at twilio.com/console
//    // and set the environment variables. See http://twil.io/secure
//    public static final String ACCOUNT_SID = "ACae3eef3bb9f4972aef8eb44930840b60";
//    public static final String AUTH_TOKEN = "d6be2b135661d3aef91a1d114922c962";
//
//    public static void main(String[] args) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                        new com.twilio.type.PhoneNumber("+254748171214"),
//                        "MGd8fad2751213b7cc79efeea4ce35f84a",
//                        "This is a scheduled message")
//                .setSendAt(
//                        ZonedDateTime.of(2024, 6, 15, 13, 57, 27, 0, ZoneId.of("UTC")))
//                .setScheduleType(Message.ScheduleType.FIXED)
//                .create();
//
//        System.out.println(message.getSid());
//    }
//}
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.example.entity.MyMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.example.repository")
@ComponentScan("org.example.controller")
@ComponentScan("org.example.service")
@SpringBootApplication
public class Main {
//    private static final String DEFAULT_USER = "ACae3eef3bb9f4972aef8eb44930840b60";
//    private static final String DEFAULT_PASS = "d6be2b135661d3aef91a1d114922c962";

    public static void main(String[] args) throws Exception{

        SpringApplication.run(Main.class, args);
//        Message message = new Message();
//
//        message.setFrom("+16144728436");
//        message.setBody("Hello there user");
//        message.setTo("+254748171214");
//
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("To", message.getTo());
//        parameters.put("From", message.getFrom());
//        parameters.put("Body", message.getBody());
////
////        ObjectMapper objectMapper = new ObjectMapper();
////        String jsonRequest = objectMapper.writeValueAsString(message);
//
//        String urlEncodedBody = parameters.entrySet()
//                .stream()
//                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
//                .collect(Collectors.joining("&"));
//
//
//        System.out.println(urlEncodedBody);
//        // Combine the user and password pair into the right format
//        String auth = DEFAULT_USER + ":" + DEFAULT_PASS;
//
//        // Encode the user-password pair string in Base64
//        byte[] encodedAuth = Base64.encodeBase64(
//                auth.getBytes(StandardCharsets.ISO_8859_1));
//
//        // Build the header String "Basic [Base64 encoded String]"
//        String authHeader = "Basic " + new String(encodedAuth);
//        System.out.println(auth);
//        System.out.println(authHeader);
//        System.out.println(encodedAuth);
//
//        HttpRequest postRequest = HttpRequest.newBuilder()
//                .uri(new URI("https://api.twilio.com/2010-04-01/Accounts/ACae3eef3bb9f4972aef8eb44930840b60/Messages.json"))
//                .setHeader(HttpHeaders.AUTHORIZATION, authHeader)
//                .POST(BodyPublishers.ofString(urlEncodedBody))
//                .build();
//
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpResponse<String> postResponse =  httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println(postResponse.body());
    }
}
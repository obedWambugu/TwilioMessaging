package org.example.controller;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.example.entity.MyMessage;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;
    private static final String DEFAULT_USER = "YOUR_USER_ID";
    private static final String DEFAULT_PASS = "YOUR_USER_PASS";


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("")
    public MyMessage createMessages(@RequestBody MyMessage message) throws URISyntaxException, IOException, InterruptedException {

        MyMessage newMessage = new MyMessage();

        newMessage.setKutoka(message.getKutoka());
        newMessage.setBody(message.getBody());
        newMessage.setMpaka(message.getMpaka());

        System.out.println(newMessage);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("To", newMessage.getMpaka());
        parameters.put("From", newMessage.getKutoka());
        parameters.put("Body", newMessage.getBody());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonRequest = objectMapper.writeValueAsString(message);
        System.out.println(parameters);
        String urlEncodedBody = parameters.entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

//        String urlEncodedBody = URLEncoder.encode(String.valueOf(message), Charset.defaultCharset());

        System.out.println(urlEncodedBody);
        // Combine the user and password pair into the right format
        String auth = DEFAULT_USER + ":" + DEFAULT_PASS;

        // Encode the user-password pair string in Base64
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(StandardCharsets.ISO_8859_1));

        // Build the header String "Basic [Base64 encoded String]"
        String authHeader = "Basic " + new String(encodedAuth);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.twilio.com/2010-04-01/Accounts/YOUR_USER_ID/Messages.json"))
                .setHeader(HttpHeaders.AUTHORIZATION, authHeader)
                .POST(HttpRequest.BodyPublishers.ofString(urlEncodedBody))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse =  httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(postResponse.body());

        return messageService.createMessage(message);
    }

}

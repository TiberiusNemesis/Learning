package com.solo.learning;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class WikipediaPage {
    Parse parse;

    WikipediaPage(){}
    WikipediaPage(Parse parse){
        this.parse = parse;
    }
}

class Parse {
    String title;
    Long pageid;
    Map<String, String> text;

    Parse(){}
    Parse(String title, Long pageid, Map<String, String> text){
        this.title = title;
        this.pageid = pageid;
        this.text = text;
    }
}

public class Solution {
    /**
     * This was part of a HackerRank interview for a certain company.
     * https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=[topic]
     *
     * @param topic The Wikipedia topic to be requested to the API.
     * @return A count of how many times the topic title appeared in the page text.
     * @throws IOException In case of an error while parsing JSON, or reading from the InputStream.
     */
    static int getTopicCount(String topic) throws IOException {
        // Initialization.
        String response;
        int numberOfMatches = 0;

        // Need to insert the topic into the URL as a string, then generate an URL object using it.
        String urlAsString = String.format("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=%s", topic);
        URL url = new URL(urlAsString);

        // Since I can't use Spring, JBoss, JAX-RS, RestEasy or whatever, my first logical choice is to use HttpURLConnection.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // We read the JSON response by using getting the above Connection's inputStream, which will return Wikipedia's response for our desired topic.
        StringBuffer responseContent = new StringBuffer();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            while ((response = in.readLine()) != null) {
                responseContent.append(response);
            }
        }


        // Using Gson, we parse the JSON String and map it to our WikipediaPage class.
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        WikipediaPage wikipediaArticle = gson.fromJson(responseContent.toString(), WikipediaPage.class);


        // Using REGEX,
        Pattern pattern = Pattern.compile(topic, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(wikipediaArticle.parse.text.get("*"));


        // we count the times that the topic name is found in the Wikipedia page text.
        while (matcher.find()) {
            numberOfMatches++;
        }

        // Then we return the total count.
        connection.disconnect();
        return numberOfMatches;
    }
}
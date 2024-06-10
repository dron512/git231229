package com.mh.green2nd.kakaomap;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

@Service
public class MainService {

    public ResponseData test(int page, int perPage) throws IOException {
        String baseURL = "https://api.odcloud.kr/api/15109594/v1/uddi:d63e68bf-e03d-4d3c-a203-fd9add3d372c?";
        String API_KEY = "lvonhIoQkirmDEKuxhlIK37isgt7wvBzOUA9lAqAx6kgM7wqtZdEmPW4/n0Gpoqz3ITehkrrTfPpOf7mSuOeKQ==";
        String queryString = new StringJoiner("&")
                .add("serviceKey=" + API_KEY)
                .add("page=" + page)
                .add("perPage=" + perPage)
                .toString();

        URL url = new URL(baseURL + queryString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setDoOutput(true);

        Charset charset = StandardCharsets.UTF_8;
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

        String inputLine;
        StringBuffer buffer = new StringBuffer();
        while ((inputLine = br.readLine()) != null) {
            buffer.append(inputLine);
        }
        br.close();
        String response = buffer.toString();

        ObjectMapper mapper = new ObjectMapper();
        ResponseData responseData = mapper.readValue(response, ResponseData.class);
        return responseData;
    }
}

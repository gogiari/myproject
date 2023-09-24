package com.gogiari.myproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Value("${GG_SERVICEKEY}")
    private String servicekey;

    @RequestMapping("/")
    public ModelAndView home() throws IOException {
        ModelAndView mv = new ModelAndView("home");

        // mv.addObject("servicekey", servicekey);

        StringBuilder urlBuilder = new StringBuilder(
                "https://api.odcloud.kr/api/15068774/v1/uddi:21d816e5-6c44-4e30-903d-e98e30a4f227"); /* URL */
        urlBuilder.append("?serviceKey=" + servicekey); /* Service Key */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        // conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        // System.out.println(sb.toString());

        mv.addObject("alba", sb);

        return mv;
    }

}

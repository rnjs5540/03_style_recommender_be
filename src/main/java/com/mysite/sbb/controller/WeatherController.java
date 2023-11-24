package com.mysite.sbb.controller;

import com.mysite.sbb.packet.requestbody.CodyRequestBody;
import com.mysite.sbb.packet.requestbody.WeatherRequestBody;
import com.mysite.sbb.packet.responsebody.CodyResponseBody;
import com.mysite.sbb.packet.responsebody.WeatherResponseBody;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WeatherController {
    @PostMapping("/weather")
    public WeatherResponseBody crawling_codies(@RequestBody WeatherRequestBody requestBody){

        WeatherResponseBody responseBody = new WeatherResponseBody();


        return responseBody;
    }
}

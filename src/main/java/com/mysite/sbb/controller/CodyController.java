package com.mysite.sbb.controller;

import com.mysite.sbb.packet.requestbody.CodyRequestBody;
import com.mysite.sbb.packet.responsebody.CodyResponseBody;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@CrossOrigin(allowedHeaders = "*")
public class CodyController {

    @PostMapping("/codies")
    public List<CodyResponseBody> crawling_codies(@RequestBody CodyRequestBody requestBody){

        final int CODY_COUNT = 12;

        List<CodyResponseBody> responseBodies = new ArrayList<>();
        // 셀레니움으로 responseBodies에 코디들 넣기

        return responseBodies;
    }

}

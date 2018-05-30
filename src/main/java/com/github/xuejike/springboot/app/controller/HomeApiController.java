package com.github.xuejike.springboot.app.controller;

import com.github.xuejike.springboot.app.domain.DeviceInfo;
import com.github.xuejike.springboot.app.domain.InfoType;
import com.github.xuejike.springboot.app.repository.DeviceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeApiController {
    @Autowired
    DeviceInfoRepository deviceInfoRepository;

    @RequestMapping("/device")
    @ResponseBody
    public String device(DeviceInfo info){
          deviceInfoRepository.save(info);
        return "";
    }
    @RequestMapping("/sleep")
    @ResponseBody
    public String sleep(){
        return "100";
    }
}

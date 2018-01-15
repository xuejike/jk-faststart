package com.github.xuejike.springboot.jkfaststart.controller.admin;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.springmvc.demo.jkbuilder.JkFormBuilder;
import com.bidanet.springmvc.demo.jkbuilder.JkTableBuilder;
import com.github.xuejike.kotlin.views.AddSysConfigKt;
import com.github.xuejike.springboot.jkfaststart.JkConfig;
import com.github.xuejike.springboot.jkfaststart.common.AjaxPage;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.config.AddSysConfig;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.config.HeaderSysConfig;
import com.github.xuejike.springboot.jkfaststart.controller.admin.view.config.TableSysConfig;
import com.github.xuejike.springboot.jkfaststart.domain.SysConfig;
import com.github.xuejike.springboot.jkfaststart.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(JkConfig.ADMIN_PATH+"/config")
@Controller
public class SysConfigController {

    @Autowired
    SysConfigService sysConfigService;

    @RequestMapping("/index")
    public String index(Model model){

        return JkTableBuilder.
                create(com.github.xuejike.kotlin.views.TableSysConfig.class).addHeaderTool(new HeaderSysConfig()).setHeightFull().build(model);
    }
    @RequestMapping("/add")
    public String add(Model model, AddSysConfig addSysConfig){
        return JkFormBuilder.create(new AddSysConfigKt()).build(model);
    }
    @RequestMapping("/add_save")
    @ResponseBody
    public AjaxCallBack addSave(SysConfig sysConfig){
        sysConfigService.save(sysConfig);
        return AjaxCallBack.saveSuccess();
    }
    @RequestMapping("/data")
    @ResponseBody
    public AjaxPage<SysConfig> data(SysConfig sysConfig,Page<SysConfig> page){
        sysConfigService.eqPage(sysConfig,page);
//
        return AjaxPage.success(page);

    }
}

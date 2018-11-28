package cn.controller;

import cn.pojo.Userinfo;
import cn.service.UserServiceimpl;
import com.alibaba.fastjson.JSON;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(value = "/Userinfo/pages")
@Controller
@RequestMapping("/Userinfo")
public class UserinfoController {
    @Autowired
    private UserServiceimpl us;

    @ResponseBody
    @RequestMapping(value ="/pages",produces = "text/plain;charset=utf-8",method = RequestMethod.POST)
    @ApiOperation(value = "信息", httpMethod = "POST", notes = "获取信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "ui", value = "Userinfo对象",
            required = false,dataType = "Userinfo", paramType = "body"),
            @ApiImplicitParam(name = "pages", value = "当前页数", required =
                    false, dataType = "Integer",paramType = "path")})
    public String seleAll(@RequestBody(required = false)Userinfo ui,
                          @RequestParam("index")Integer pages) {
        return JSON.toJSONString(us.sele(ui,pages));
    }
}

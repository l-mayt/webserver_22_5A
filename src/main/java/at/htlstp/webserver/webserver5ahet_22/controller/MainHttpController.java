package at.htlstp.webserver.webserver5ahet_22.controller;

import at.htlstp.webserver.webserver5ahet_22.endpoints.Endpoint;
import at.htlstp.webserver.webserver5ahet_22.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class MainHttpController {

    @Autowired
    private DataService databaseService;


    @RequestMapping(Endpoint.info)
    public String info(Model model) {
        databaseService.read("select * from abteilungen");
        model.addAttribute("datum",new Date());
        return "info";
    }
}

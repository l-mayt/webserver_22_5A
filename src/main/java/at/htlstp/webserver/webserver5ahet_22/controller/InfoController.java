package at.htlstp.webserver.webserver5ahet_22.controller;

import at.htlstp.webserver.webserver5ahet_22.endpoints.Endpoints;
import at.htlstp.webserver.webserver5ahet_22.model.WiderstandsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class InfoController {
    @RequestMapping(Endpoints.info)
    public String info(Model model) {
        model.addAttribute("datum", new Date());
        return "info";
    }

    @RequestMapping(Endpoints.widerstandsForm)
    public String widerstand(Model model) {
        model.addAttribute("wid", new WiderstandsModel());
        model.addAttribute("action", Endpoints.widerstandsErg);
        return "widerstand";
    }

    @RequestMapping(Endpoints.widerstandsErg)
    public String widerstandErg(@ModelAttribute WiderstandsModel r, Model model) {
        String res = "R1="+ r.getR1() + ", R2=" + r.getR2();
        model.addAttribute("erg", res);
        return "widerstandResult";
    }

}

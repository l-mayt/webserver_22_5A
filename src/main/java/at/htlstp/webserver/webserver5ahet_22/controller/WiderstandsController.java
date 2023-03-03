package at.htlstp.webserver.webserver5ahet_22.controller;

import at.htlstp.webserver.webserver5ahet_22.endpoints.Endpoint;
import at.htlstp.webserver.webserver5ahet_22.model.WiderstandModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WiderstandsController {

    @RequestMapping(Endpoint.widerstand)
    public String widerstandForm(Model model) {
        model.addAttribute("action",Endpoint.widerstandResult);
        return "widerstand";
    }
    @RequestMapping(Endpoint.widerstandResult)
    public String widerstandResult(@ModelAttribute WiderstandModel widerstandModel, Model model) {
        double Rges=0;
        try {
            double R1 = Double.parseDouble(widerstandModel.r1);
            double R2 = Double.parseDouble(widerstandModel.r2);
            Rges = R1 + R2;
        } catch (Exception ex) {
            model.addAttribute("msg","Fehler!");
            model.addAttribute("action",Endpoint.widerstandResult);
            model.addAttribute("wid",widerstandModel);
            return "widerstand";
        }
        model.addAttribute("rges",Rges);
        model.addAttribute("back",Endpoint.widerstand);
        return "widerstandResult";
    }

}

package controllers;

import models.Statistic;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.StatisticService;

/**
 * Created by LulzimG on 17/12/16.
 */
@Controller
public class HomeController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping("/")
    public String getHome(Model model, SessionStatus status) {
        Statistic statistic = statisticService.getStatistic();
        model.addAttribute("statistic", statistic);

        status.setComplete();
        return "index";
    }
}

package com.example.plug.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/frontEnd/")
public class FrontEndController {

    MainController stat, stat1;
    PermissionController stat2;

    public FrontEndController(MainController stat, MainController stat1, PermissionController stat2){
        this.stat = stat;
        this.stat1 = stat1;
        this.stat2 = stat2;
    }

    private static final Logger logger = LoggerFactory.getLogger(FrontEndController.class);

    @GetMapping("/")
    public String hello() {

        return    "\nСтатистика по заглушке\n\n" +
                "\n\tКоличество входящих запросов " + stat.stat_in +
                "\n\tКоличество ответов заглушки " + stat.stat_out +
                "\n\tКоличество ошибок при ответах " + stat.stat_err +
                "\n\n\t* Статистика запросов *\n\n";
    }

    @GetMapping(value = "/stats", produces = "application/json")
    public String get_stats() {
        String title ="\nСтатистика по заглушкам:\n\n" +
                "***********По заглушке postDepositsBalances\n\n\tКолиечство входящих запросов " + stat.stat_in +
                "\n\tКоличество ответов заглушки " + stat.stat_out +
                "\n\tОшибок при ответах " + stat.stat_err + "\n" +
                "\n***********По заглушке getDepositsBalances\n\n\tКолиечство входящих запросов " + stat1.stat_in1 +
                "\n\tКоличество ответов заглушки " + stat1.stat_out1 +
                "\n\tОшибок при ответах " + stat1.stat_err1 + "\n" +
                "\n***********По заглушке postPermissions\n\n\tКолиечство входящих запросов " + stat2.stat_in2 +
                "\n\tКоличество ответов заглушки " + stat2.stat_out2 +
                "\n\tОшибок при ответах " + stat2.stat_err2 +
                "\n\n\t* Статистика запросов *\n\n";


        for (String[] num : stat.stat_tps) {
            title += "\t Период: " + num[0] + "\t тпс: " + num[1] + "\t запросов: " + num[2] + "\t meanRespTime: " + num[3] + "\n";
        }
        title += "\n";
        for (String[] num : stat1.stat_tps1) {
            title += "\t Период: " + num[0] + "\t тпс: " + num[1] + "\t запросов: " + num[2] + "\t meanRespTime: " + num[3] + "\n";
        }
        title += "\n";
        for (String[] num : stat2.stat_tps2) {
            title += "\t Период: " + num[0] + "\t тпс: " + num[1] + "\t запросов: " + num[2] + "\t meanRespTime: " + num[3] + "\n";
        }

        return title;
    }

    @GetMapping(value = "/clear", produces = "application/json")
    public String drop_stats() {
        stat.stat_in = 0; stat.stat_err = 0; stat.stat_out = 0; stat.stat_curr = 0; stat.sum_time = 0; stat.stat_tps.clear();
        stat1.stat_in1 = 0; stat1.stat_err1 = 0; stat1.stat_out1 = 0; stat1.stat_curr1 = 0; stat1.sum_time1 = 0; stat1.stat_tps1.clear();
        stat2.stat_in2 = 0; stat2.stat_err2 = 0; stat2.stat_out2 = 0; stat2.stat_curr2 = 0; stat2.sum_time2 = 0; stat2.stat_tps2.clear();

        return "\n\tСтатистика по заглушкам очищена\n";
    }
}

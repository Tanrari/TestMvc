package ru.web.dto;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@RequestMapping("/singers")
@Controller
public class SingerController {
    private final Logger logger = Logger.getLogger(SingerController.class);

    private SingerService singerService;
//    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET,value = "/list")
    public String list(Model model){
//        System.out.println("111");
        logger.info("Listing singers");
        List<Singer> singers = singerService.findAll();
        model.addAttribute("singers", singers);
        logger.info("No. of singers"+singers.size());
        return ";l,";
    }

    @Autowired
    public void setSingerService(SingerService singerService){
        this.singerService = singerService;
    }
}

package ru.web.dto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/singers")
@Controller
public class SingerController {
    private final Logger logger = Logger.getLogger(SingerController.class);

    private SingerService singerService;
//    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        logger.info("Listing singers");
        List<Singer> singers = singerService.findAll();
        model.addAttribute("singers", singers);
        logger.info("No. of singers"+singers.size());
        return "singers/list";
    }

    @Autowired
    public void setSingerService(SingerService singerService){
        this.singerService = singerService;
    }
}

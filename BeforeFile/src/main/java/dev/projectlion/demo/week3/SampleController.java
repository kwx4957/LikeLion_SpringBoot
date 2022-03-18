package dev.projectlion.demo.week3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("view")
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(@RequestParam(name = "id", required = false) String id) {
        logger.info("Path : hello");
        logger.info("Query Param id" + id);
        return "/hello1";
    }

    @GetMapping(value = "hello/{id}")
    public String helloPath(@PathVariable("id") String id) {
        logger.info(id);
        return "/hello.html";
    }

    @GetMapping(value = "hel3lo/{id}")
    public String helloPat3h(@PathVariable("id") String id) {
        logger.info(id);
        return "/hello.html";
    }

    @GetMapping(value = "/getProfile")
    public @ResponseBody
    SamplePayload getProfile() {
        return new SamplePayload("kimdyoung", 33, "Develoeop");
    }

    @GetMapping("/sampleJsp")
    public String sampleJsp(Model model){
        logger.info("in sample jsp");
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("adma", 22, "dovelooo"));
        profiles.add(new SamplePayload("Bob", 32, "dovelooo"));
        profiles.add(new SamplePayload("chirs", 25, "dovelooo"));

        model.addAttribute("profiles",profiles);

        return "view";
    }

    @GetMapping("/sampleTheme")
    public ModelAndView sampleThyme(){
        logger.info("in sample Theme");
        ModelAndView modelAndView = new ModelAndView();
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("adma", 22, "dovelooo"));
        profiles.add(new SamplePayload("Bob", 32, "dovelooo"));
        profiles.add(new SamplePayload("chirs", 25, "dovelooo"));

        modelAndView.addObject("profiles", profiles);
        modelAndView.setViewName("view-thyme");
        return modelAndView;
    }
}

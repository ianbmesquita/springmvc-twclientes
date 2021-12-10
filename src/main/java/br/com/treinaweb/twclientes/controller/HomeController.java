package br.com.treinaweb.twclientes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    // @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    private String home() {
        return "home";
    }

    @GetMapping("/mensagem")
    private String mensagem(Model model) {
        model.addAttribute("mensagem", "Bem vindos!!!");
        
        return "mensagem";
    }

    // @GetMapping("/saudacao/{nome}")
    // private ModelAndView saudacao(@PathVariable String nome) {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("saudacao");
    //     modelAndView.addObject("nome", nome);

    //     return modelAndView;
    // }

    //treinaweb.com.br/saudacao?nome=Ian
    @GetMapping("/saudacao")
    private ModelAndView saudacao(@RequestParam(required = false, defaultValue = "Treinaweb") String nome) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("saudacao");
        modelAndView.addObject("nome", nome);

        return modelAndView;
    }
    
}

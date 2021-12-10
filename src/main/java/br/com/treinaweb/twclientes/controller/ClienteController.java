package br.com.treinaweb.twclientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.twclientes.repository.ClienteRepository;
import br.com.treinaweb.twclientes.model.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ModelAndView listar() {
        List<Cliente> clientes = clienteRepository.findAll(); 

        ModelAndView modelAndView = new ModelAndView("cliente/listar.html");
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getById(id);

        ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }

}

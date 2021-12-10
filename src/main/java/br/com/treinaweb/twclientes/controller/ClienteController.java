package br.com.treinaweb.twclientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("cliente/cadastrar.html");
        modelAndView.addObject("cliente", new Cliente());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Cliente cliente) {
        clienteRepository.save(cliente);

        return new ModelAndView("redirect:/cliente");
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        clienteRepository.deleteById(id);

        return new ModelAndView("redirect:/cliente");
    }

}

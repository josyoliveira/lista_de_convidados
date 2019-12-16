package com.algaworks.festa.gestaofesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

    @Autowired
    private Convidados convidados;

    @RequestMapping()
    public ModelAndView listar(){
         ModelAndView mv = new ModelAndView("ListaConvidados");
         mv.addObject(new Convidado());
         mv.addObject("convidados",convidados.todos());
         return mv;
    }
    @RequestMapping(method = RequestMethod.POST)
    public String salvar(Convidado convidado){
        this.convidados.adicionar(convidado);
        return "redirect:/convidados";
    }
   
}
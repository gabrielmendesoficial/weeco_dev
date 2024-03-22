package br.com.weeco.sustentabilidades.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto")
public class ProdutoView {

    @GetMapping("/")
    public ModelAndView listarProdutos()
    {
        ModelAndView modelAndView = new ModelAndView("produto/list");
        // Add any necessary model attributes here
        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView novoProduto()
    {
        ModelAndView modelAndView = new ModelAndView("produto/form");
        // Add any necessary model attributes here
        return modelAndView;
    }
}
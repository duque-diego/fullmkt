package app.fullmkt.controller;

import app.fullmkt.entity.Produto;
import app.fullmkt.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
public class CadastroProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/produto", method = RequestMethod.GET)
    public List<Produto> cadastroUsuarioApp() {
        return (List<Produto>) produtoRepository.findAll();
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    public Produto Post (@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @CrossOrigin
    @RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Produto> produto = Optional.ofNullable(produtoRepository.findById(id));
        if(produto.isPresent()){
            produtoRepository.delete(produto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Produto> pessoa = Optional.ofNullable(produtoRepository.findById(id));
        if(pessoa.isPresent())
            return new ResponseEntity<Produto>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/produto/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Produto> Put(@PathVariable(value = "id") long id, @RequestBody Produto newProduto)
    {
        Optional<Produto> oldProduto = Optional.ofNullable(produtoRepository.findById(id));
        if(oldProduto.isPresent()){
            Produto produto = oldProduto.get();
            produto.setTitle(newProduto.getTitle());
            produto.setDisccount(newProduto.getDisccount());
            produto.setUrlImage(newProduto.getUrlImage());
            produtoRepository.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

package app.fullmkt.controller;

import app.fullmkt.entity.Cliente;
import app.fullmkt.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;
import java.util.Optional;

@RestController
public class CadastroClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Cliente> cadastroUsuarioApp() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public Cliente Post (@RequestBody Cliente cliente) {
        cliente.setSenha(bcryptEncoder.encode(cliente.getSenha()));
        return clienteRepository.save(cliente);
    }

    @CrossOrigin
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Cliente> cliente = Optional.ofNullable(clienteRepository.findById(id));
        if(cliente.isPresent()){
            clienteRepository.delete(cliente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Cliente> pessoa = Optional.ofNullable(clienteRepository.findById(id));
        if(pessoa.isPresent())
            return new ResponseEntity<Cliente>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/cliente/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Cliente> Put(@PathVariable(value = "id") long id, @RequestBody Cliente newCliente)
    {
        Optional<Cliente> oldCliente = Optional.ofNullable(clienteRepository.findById(id));
        if(oldCliente.isPresent()){
            Cliente cliente = oldCliente.get();
            cliente.setNome(newCliente.getNome());
            cliente.setEmail(newCliente.getEmail());
            cliente.setTelefone(newCliente.getTelefone());
            cliente.setSexo(newCliente.getSexo());
            cliente.setDataNascimento(newCliente.getDataNascimento());
            cliente.setCpf(newCliente.getCpf());
            clienteRepository.save(cliente);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

package br.com.teste.prova.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.prova.entity.Cliente;
import br.com.teste.prova.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "teste")
@RequestMapping(value = "/cliente", produces = "application/json")
public class ClienteController {

	
	private ClienteService clienteService;
	
    @Autowired
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

	
    @ApiOperation(httpMethod = "POST", value = "Método post para salvar um cliene.")
    @ApiResponses(value = {
    		@ApiResponse(code = 201, message = "Criado",  response = Cliente.class),
    })
    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Cliente cliente){

    	cliente = clienteService.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
    
    
    @ApiOperation(httpMethod = "GET", value = "Detalhamento do cliente.")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Detalhamento do cliente", response = Cliente.class),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@ApiParam(value = "Id", required = true)  @PathVariable(value="id", required = true) Integer id){

    	Cliente cliente = clienteService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }
}

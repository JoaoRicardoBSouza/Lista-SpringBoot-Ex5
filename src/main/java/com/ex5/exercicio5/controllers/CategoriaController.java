package com.ex5.exercicio5.controllers;

import com.ex5.exercicio5.models.CategoriaModel;
import com.ex5.exercicio5.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(name = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll(){
        List<CategoriaModel> categoriaModelList = categoriaService.findAll();

        return ResponseEntity.ok().body(categoriaModelList);
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel categoriaModel){
        CategoriaModel novaCategoria = categoriaService.criarCategoria(categoriaModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaCategoria.getId()).toUri();

        return ResponseEntity.created(uri).body(novaCategoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaModel>> findById(@PathVariable Long id){
        Optional<CategoriaModel> categoriaModelOptional = categoriaService.findById(id);

        return ResponseEntity.ok().body(categoriaModelOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);

        return ResponseEntity.noContent().build();
    }
}

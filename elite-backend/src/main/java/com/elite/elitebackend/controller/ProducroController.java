package com.elite.elitebackend.controller;

import com.elite.elitebackend.model.Producto;
import com.elite.elitebackend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProducroController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> listar(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Integer id){
        return productoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody Producto producto){
        producto.setId(id);
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Integer id){
        productoRepository.deleteById(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.DTO.ProductoDTO;
import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DAYIRO
 */
@RestController
@RequestMapping("/api") 
public class ProductoController {

    
    @Autowired
    ProductoService productoService;
     

    
    @ResponseBody
    @GetMapping(value = "test")
    public String test(){
    	return "ok";
    }

    @GetMapping(value="/productos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> listarProducto() throws Exception {
            List<Producto> lsProducto = productoService.getListarProducto();
            if(lsProducto == null) {
                    throw new Exception("NO HAY REGISTRO");
            }
            return new ResponseEntity<List<Producto>>(lsProducto, HttpStatus.OK);
    }
    @GetMapping(value="/productos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> listarProducto(@PathVariable("id") String id) throws Exception {
            List<Producto> lsProducto = productoService.getProducto(id);
            if(lsProducto == null) {
                    throw new Exception("NO HAY REGISTRO");
            }
            return new ResponseEntity<List<Producto>>(lsProducto, HttpStatus.OK);
    }
  @PostMapping("/productos")
  public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
    try {
       
      productoService.crearProducto(producto);

      return new ResponseEntity<>(producto, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/productos/{id}")
  public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") String id, @RequestBody Producto producto) {
    try {
       
      productoService.actualizarProducto(id, producto);

      return new ResponseEntity<>(producto, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/productos/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
    try {
        
      productoService.eliminarProducto(id);

      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}

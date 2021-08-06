/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.DAO.ProductoDAO;
import com.example.demo.DTO.ProductoDTO;
import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAYIRO
 */
@Service
public class ProductoServiceImpl implements ProductoService{
    

    
    @Autowired
    ProductoRepository productoRepository;
    
    public List<Producto> getListarProducto(){
        
        return productoRepository.findAll();
    
    }
    
    public List<Producto> getProducto(String id){
        
        List<Producto> lsProd=new ArrayList();
        lsProd.add(productoRepository.findById(id).get());
        
        return lsProd;
    
    }
    
    public void crearProducto(Producto producto){
        
        productoRepository.save(producto);
        
    }
    
    public void actualizarProducto(String id, Producto producto){
        
        Optional<Producto> productoGuardado = productoRepository.findById(id);
        
        Producto nuevoProducto=productoGuardado.get();
        nuevoProducto.setNombre(producto.getNombre());
        nuevoProducto.setPrecio(producto.getPrecio());

        productoRepository.save(nuevoProducto);
        
    }
    
    public void eliminarProducto(String id){

        productoRepository.deleteById(id);
        
    }

}

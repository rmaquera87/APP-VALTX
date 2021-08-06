/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.DTO.ProductoDTO;
import com.example.demo.entity.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author DAYIRO
 */
public interface ProductoService {
    public List<Producto> getListarProducto();
    public List<Producto> getProducto(String id);
    public void crearProducto(Producto producto);
    public void actualizarProducto(String id, Producto producto);
    public void eliminarProducto(String id);
}

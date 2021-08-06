/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.DAO.impl;

import com.example.demo.DAO.ProductoDAO;
import com.example.demo.DTO.ProductoDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

/**
 *
 * @author DAYIRO
 */

@Repository
public class ProductoDAOImpl implements ProductoDAO {
    
    private transient final Log LOGGER = LogFactory.getLog(getClass());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<ProductoDTO> getListarProducto() {
        StringBuffer sql = new StringBuffer();
        List<ProductoDTO> list = new ArrayList<ProductoDTO>();
        sql.append("SELECT * ");
        sql.append("FROM producto ");

        try {
            list = this.jdbcTemplate.query(sql.toString(), BeanPropertyRowMapper.newInstance(ProductoDTO.class));
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
        return list;
    }
}


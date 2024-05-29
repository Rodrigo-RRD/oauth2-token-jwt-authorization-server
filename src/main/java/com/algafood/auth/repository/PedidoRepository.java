package com.algafood.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algafood.auth.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}

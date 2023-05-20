package com.projeto.idealcolors.repository;


import com.projeto.idealcolors.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

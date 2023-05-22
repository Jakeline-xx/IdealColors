package com.projeto.idealcolors.repository;

import com.projeto.idealcolors.model.ColoracaoPessoal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoracaoPessoalRepository extends JpaRepository<ColoracaoPessoal, Long> {
    Page<ColoracaoPessoal> findByCorDosOlhosContaining(String corDosOlhos, Pageable pageable);
}
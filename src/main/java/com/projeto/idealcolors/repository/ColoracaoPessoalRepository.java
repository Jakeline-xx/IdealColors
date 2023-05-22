package com.projeto.idealcolors.repository;

import com.projeto.idealcolors.model.ColoracaoPessoal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColoracaoPessoalRepository extends JpaRepository<ColoracaoPessoal, Long> {
    Page<ColoracaoPessoal> findByEyeColorContaining(String corDosOlhos, Pageable pageable);
}
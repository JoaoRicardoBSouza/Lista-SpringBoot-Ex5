package com.ex5.exercicio5.repositories;

import com.ex5.exercicio5.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}

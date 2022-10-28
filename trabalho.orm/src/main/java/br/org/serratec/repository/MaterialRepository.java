package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
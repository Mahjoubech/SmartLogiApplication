package io.github.Mahjoubech.smartlogi.repository;

import io.github.Mahjoubech.smartlogi.entity.Colis;
import io.github.Mahjoubech.smartlogi.enums.StatutColis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColisRepository extends JpaRepository<Colis,Long> {
    List<Colis> findByLivreurId(Long livreurId);
}

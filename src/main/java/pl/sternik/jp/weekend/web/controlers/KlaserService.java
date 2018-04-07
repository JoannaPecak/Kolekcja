package pl.sternik.jp.weekend.web.controlers;


import java.awt.List;
import java.util.Optional;


public interface KlaserService {
    List findAll();

    List findAllToSell();

    Optional<Moneta> findById(Long id);

    Optional<Moneta> create(Moneta moneta);

    Optional<Moneta> edit(Moneta moneta);

    Optional<Boolean> deleteById(Long id);

    List findLatest3();
}

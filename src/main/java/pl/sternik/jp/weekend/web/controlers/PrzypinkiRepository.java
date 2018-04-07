package pl.sternik.jp.weekend.web.controlers;

import java.util.List;

import pl.sternik.jp.weekend.web.controler.Przypinka;



public interface PrzypinkiRepository {
    Przypinka create(Przypinka przypinka) throws PrzypinkaAlreadyExistsException;
    Przypinka readById(Long id) throws NoSuchPrzypinkaException;
    Przypinka update(Przypinka przypinka) throws NoSuchPrzypinkaException;
    void deleteById(Long id) throws NoSuchPrzypinkaException;
    List<Przypinka> findAll();
}
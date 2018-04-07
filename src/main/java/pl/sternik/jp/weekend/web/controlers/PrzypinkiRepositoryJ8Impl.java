package pl.sternik.jp.weekend.web.controlers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.sternik.kk.weekend.entities.Moneta;
import pl.sternik.kk.weekend.entities.Status;


@Service
@Qualifier("lista")
public class PrzypinkiRepositoryJ8Impl implements PrzypinkiRepository {

    private List<Przypinka> monety = new ArrayList<Przypinka>() {
        private static final long serialVersionUID = 1L;
        {
            add(Przypinka.producePrzypinka(1L, "Polska", 1L, "mm", "first Przypinka", new Date(), new BigDecimal("1.2"),
                    Status.NOWA));
            add(Przypinka.producePrzypinka(2L, "Polska", 1L, "mm", "Second Przypinka", new Date(), new BigDecimal("1.2"), Status.DUBLET));
            add(Przypinka.producePrzypinka(3L, "Polska", 1L, "mm", "Forth Przypinka", new Date(), new BigDecimal("1.2"),
                    Status.NOWA));
            add(Przypinka.producePrzypinka(4L, "Polska", 1L, "mm", "Przypinka Number 5", new Date(), new BigDecimal("1.2"), Status.NOWA));
            add(Przypinka.producePrzypinka(5L, "Polska", 1L, "mm", "Sixth Przypinka", new Date(), new BigDecimal("1.2"), Status.NOWA));
        }
    };
	private Object przypinka;

    @Override
    public List<Przypinka> findAll() {
        return this.przypinki;
    }

    @Override
    public Przypinka readById(Long id) throws NoSuchPrzypinkaException {
        return this.przypinki.stream().filter(p -> Objects.equals(p.getNumer(), id)).findFirst()
                .orElseThrow(NoSuchPrzypinkaException::new);
    }

    @Override
    public Przypinka create(Przypinka przypinka) {
        if (!przypinki.isEmpty()) {
            przypinka.setNumer(
                    this.przypinka.stream().mapToLong(p -> p.getNumer()).max().getAsLong() + 1);
        } else {
            przypinka.setNumer(1L);
        }
        this.monety.add(przypinka);
        return przypinka;
    }

    @Override
    public Przypinka update(Przypinka przypinka) throws NoSuchPrzypinkaException {
        for (int i = 0; i < this.przypinki.size(); i++) {
            if (Objects.equals(this.monety.get(i).getNumer(), przypinka.getNumer())) {
                this.przypinki.set(i, przypinka);
                return przypinka;
            }
        }
        throw new NoSuchPrzypinkaException(" " + przypinka.getNumer());
    }

    @Override
    public void deleteById(Long id) throws NoSuchPrzypinkaException {
        for (int i = 0; i < this.przypinka.size(); i++) {
            if (Objects.equals(this.przypinka.get(i).getNumer(), id)) {
                this.przypinka.remove(i);
            }
        }
        throw new NoSuchPrzypinkaException(" " + id);
    }

}
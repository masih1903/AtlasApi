package app.daos;

import app.dtos.CountryDTO;
import app.entities.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CountryDAO implements IDAO<Country> {

    private final EntityManagerFactory emf;

    public CountryDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public Country getById(Integer id) {
        return null;
    }

    @Override
    public List<Country> getAll() {
        return List.of();
    }

    @Override
    public void create(Country country) {

    }

    @Override
    public void update(Country country) {

    }

    @Override
    public void delete(Integer id) {

    }

    public void saveCountriesToDb(List<CountryDTO> countryDtoList) {

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            for (CountryDTO countryDTO : countryDtoList) {

                Country country = new Country(countryDTO);
                em.persist(country);
            }

            em.getTransaction().commit();
        }
    }

}
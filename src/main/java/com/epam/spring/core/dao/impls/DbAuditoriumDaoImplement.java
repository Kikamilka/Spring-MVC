package com.epam.spring.core.dao.impls;

import com.epam.spring.core.dao.impls.exeptions.DaoDbExeption;
import com.epam.spring.core.dao.impls.mappers.AuditoriumMapper;
import com.epam.spring.core.dao.interfaces.AuditoriumDao;
import com.epam.spring.core.domain.Auditorium;
import java.util.List;
import org.postgresql.core.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbAuditoriumDaoImplement implements AuditoriumDao {

    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = new Logger();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Auditorium auditorium) {
        jdbcTemplate.update("INSERT INTO bookingservice.auditorium VALUES (?, ?, ?, ?)",
                null,
                auditorium.getName(),
                auditorium.getSeatsNumber(),
                auditorium.getVipSeats());
        try {
            auditorium.setId(jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium "
                    + "WHERE name = ?",
                    new Object[]{auditorium.getName()},
                    new AuditoriumMapper()).getId());
        } catch (DataAccessException ex) {
            logger.info(ex.getMessage(), ex.fillInStackTrace());
            throw new DaoDbExeption(ex);
        }
    }

    @Override
    public List<Auditorium> getAuditoriums() {
        try {
            return jdbcTemplate.query("SELECT * FROM bookingservice.auditorium ",
                    new AuditoriumMapper());
        } catch (DataAccessException ex) {
            logger.info(ex.getMessage(), ex.fillInStackTrace());
            throw new DaoDbExeption(ex);
        }
    }

    @Override
    public int getSeatsNumber(String auditoriumId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium "
                    + "WHERE id = ?",
                    new Object[]{auditoriumId},
                    new AuditoriumMapper()).getSeatsNumber();
        } catch (DataAccessException ex) {
            logger.info(ex.getMessage(), ex.fillInStackTrace());
            throw new DaoDbExeption(ex);
        }
    }

    @Override
    public String getVipSeats(String auditoriumId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium "
                    + "WHERE idAuditorium = ?",
                    new Object[]{auditoriumId},
                    new AuditoriumMapper()).getVipSeats();
        } catch (DataAccessException ex) {
            logger.info(ex.getMessage(), ex.fillInStackTrace());
            throw new DaoDbExeption(ex);
        }
    }
}

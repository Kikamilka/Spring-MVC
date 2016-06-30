package com.epam.spring.core.dao.impls;

import com.epam.spring.core.dao.impls.exeptions.DaoDbExeption;
import com.epam.spring.core.dao.impls.mappers.TicketMapper;
import com.epam.spring.core.dao.impls.mappers.UserMapper;
import com.epam.spring.core.dao.interfaces.UserDao;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import org.postgresql.core.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbUserDaoImplement implements UserDao {

    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = new Logger();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void register(User user) {
        Random random = new Random();
        String randId = String.valueOf(random.nextInt(50) + 10);
        jdbcTemplate.update("INSERT INTO bookingservice.user VALUES (?, ?, ?, ?)",
                randId,
                user.getName(),
                user.getEmail(),
                user.getBirthday());
    }

    @Override
    public void remove(String id) {
        jdbcTemplate.update("DELETE FROM bookingservice.user "
                + "WHERE id = ?",
                id);
    }

    @Override
    public User getById(String id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                    + "WHERE id = ?",
                    new Object[]{id},
                    new UserMapper());
        } catch (DataAccessException ex) {
            logger.info(ex.getMessage(), ex.fillInStackTrace());
            //System.out.println("User with id: " + id + "does'n exist");
            try {                
                throw new DaoDbExeption(ex.getMessage());
            } catch (DaoDbExeption ex1) {
                java.util.logging.Logger.getLogger(DbAuditoriumDaoImplement.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }

    @Override
    public User getUsersByName(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                    + "WHERE name = ?",
                    new Object[]{name},
                    new UserMapper());
        } catch (DataAccessException ex) {
            logger.info(ex.getMessage(), ex.fillInStackTrace());
            //System.out.println("User with name: " + name + "does'n exist");
            try {                
                throw new DaoDbExeption(ex.getMessage());
            } catch (DaoDbExeption ex1) {
                java.util.logging.Logger.getLogger(DbAuditoriumDaoImplement.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                    + "WHERE email = ?",
                    new Object[]{email},
                    new UserMapper());
        } catch (DataAccessException ex) {
            logger.info(ex.getMessage(), ex.fillInStackTrace());
            //System.out.println("User with email: " + email + "does'n exist");
            try {                
                throw new DaoDbExeption(ex.getMessage());
            } catch (DaoDbExeption ex1) {
                java.util.logging.Logger.getLogger(DbAuditoriumDaoImplement.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(String userId) {
        try {
            return jdbcTemplate.query("SELECT * FROM bookingservice.bookedticket "
                    + "WHERE idUser = ?",
                    new Object[]{userId},
                    new TicketMapper());
        } catch (DataAccessException ex) {
            logger.info(ex.getMessage(), ex.fillInStackTrace());
            //System.out.println("User with id: " + userId + "does'n exist");
            try {                
                throw new DaoDbExeption(ex.getMessage());
            } catch (DaoDbExeption ex1) {
                java.util.logging.Logger.getLogger(DbAuditoriumDaoImplement.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM bookingservice.user ",
                    new UserMapper());
        } catch (DataAccessException ex) {
            logger.info(ex.getMessage(), ex.fillInStackTrace());
            //System.out.println("Users list does'n exist");
            try {                
                throw new DaoDbExeption(ex.getMessage());
            } catch (DaoDbExeption ex1) {
                java.util.logging.Logger.getLogger(DbAuditoriumDaoImplement.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }

}

package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.IbecaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class becaServiceImpl implements IbecaService {

    static final Logger LOG = LogManager.getLogger(becaServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDO> getAllUsers() {
        return (List<UserDO>) this.userDAO.findAll();

    }

    @Override
    public UserDO getIdUser(int id) {

        return this.userDAO.findById((long) id).get();//manejo de excepcion para que no sea el resultado del arreglo nulo
    }

    @Override
    public UserDO deleteUser(Long id) {
        this.userDAO.deleteById(id);
        return null;
    }

    @Override
    public UserDO insertUser(UserDO userDO) {
        this.userDAO.save(userDO);
        return null;
    }


}

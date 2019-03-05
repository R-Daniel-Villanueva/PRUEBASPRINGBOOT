package mx.com.axity.services.facade;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;

import java.util.List;

public interface IbecaFacade {

    List<UserTO> getAllUsers();
    UserTO getIdUser(int id);
    UserTO deleteUser(Long id);
    UserDO insertUser(UserDO userDO);
}

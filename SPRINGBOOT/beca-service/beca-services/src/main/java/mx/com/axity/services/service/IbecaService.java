package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;

import java.util.List;

public interface IbecaService {

    List<UserDO> getAllUsers();
    UserDO getIdUser(int id);
    UserDO deleteUser(Long id);
    UserDO insertUser(UserDO userDO);


}


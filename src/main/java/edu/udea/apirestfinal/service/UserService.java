package edu.udea.apirestfinal.service;

import edu.udea.apirestfinal.model.User;
import edu.udea.apirestfinal.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IDao<User> {

    @Autowired
    private IDao<User> userIDao;

    public IDao<User> getUserIdao(){return userIDao;}

    public void setUserIdao(IDao<User> userIDao){this.userIDao = userIDao;}

    @Override
    public int guardar(User user){
        return userIDao.guardar(user);
    }

    @Override
    public void eliminar(Long id){
        userIDao.eliminar(id);
    }

    @Override
    public User buscar(Long id){
        return userIDao.buscar(id);
    }

    @Override
    public List<User> buscarTodos(){
        return userIDao.buscarTodos();
    }

    @Override
    public int editar(User user) {
        return userIDao.editar(user);
    }


}

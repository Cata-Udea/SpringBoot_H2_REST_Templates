package edu.udea.apirestfinal.service;

import edu.udea.apirestfinal.model.Rol;
import edu.udea.apirestfinal.dao.IDao;
import edu.udea.apirestfinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IDao<Rol> {

    @Autowired
    private IDao<Rol> rolIDao;

    public IDao<Rol> getRolIdao(){return rolIDao;}

    public void setRolIdao(IDao<Rol> rolIDao){this.rolIDao = rolIDao;}

    @Override
    public List<Rol> buscarTodos(){
        return rolIDao.buscarTodos();
    }

    @Override
    public int guardar(Rol rol){
        return 0;//rolIDao.guardar(rol);
    }

    @Override
    public void eliminar(Long id){
        rolIDao.eliminar(id);
    }

    @Override
    public Rol buscar(Long id){
        return rolIDao.buscar(id);
    }



    @Override
    public int editar(Rol rol) {
        return 0;
    }

}


package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import project.ifs.CrudInterface;
import project.model.network.Header;

@Component
public abstract class BaseService<Req,Res, Entity> implements CrudInterface<Req, Res>{
    
    @Autowired(required = false)
    protected JpaRepository<Entity, Long> baseRepository;
}
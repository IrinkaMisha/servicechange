package by.nulay.changer.films;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import by.imix.cms.nodedata.service.hib.GenericHibernateDAO;

import java.util.List;

/**
 * Created by miha on 08.10.2014.
 */

@Transactional(readOnly = true)
public class FilmServiceHib<T extends  Film,ID extends Number> extends GenericHibernateDAO<T,ID> implements FilmService<T,ID> {

    private static Logger log= Logger.getLogger(FilmServiceHib.class);

    private GenericHibernateDAO<Seria, Long> ndhghS = new GenericHibernateDAO<Seria, Long>(Seria.class,sessionFactory);

    public GenericHibernateDAO<Seria, Long> getNdhghS() {
        return ndhghS;
    }

    @Override
    @Transactional
    public T addFilm(T film){
        return saveOrUpdate(film);
    }

    @Override
    @Transactional
    public Seria addSeria(Seria seria){
        return getNdhghS().saveOrUpdate(seria);
    }

    @Override
    public T getFilm(String name, String year) {
        return (T) getSession().createQuery("FROM "+getPersistentClass().getName()+" WHERE name=:name AND dateBegin=:year").setString("name",name).setString("year",year).uniqueResult();
    }

    @Override
    public List<T> geeListFilm(String name){
        return getSession().createQuery("FROM "+getPersistentClass().getName()+" WHERE name=:name").setString("name",name).list();
    }

    @Override
    public List<T> getAllFilm(){
         return getAll();
    }
}

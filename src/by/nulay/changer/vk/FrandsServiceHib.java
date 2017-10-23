package by.nulay.changer.vk;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import by.imix.cms.nodedata.service.hib.GenericHibernateDAO;

import java.util.List;

/**
 * Created by miha on 24.07.2014.
 */

@Transactional(readOnly = true )
public class FrandsServiceHib<T extends Frands,ID extends Number> extends GenericHibernateDAO<T,ID> implements FrandsService<T,ID> {
    private static Logger log= Logger.getLogger(FrandsServiceHib.class);

//    @Autowired
//    public FrandsServiceHib(SessionFactory sessionFactory) {
//        super(sessionFactory);
//    }

    @Override
    @Transactional
    public Frands addFrands(Frands frands){
        saveOrUpdate((T) frands);
        return frands;
    }

    @Override
    public boolean isAddFrands(Frands frands){
        List<Frands> lfr=getSession().createQuery("FROM "+getPersistentClass().getName()+" f WHERE f.frandid=:frandid and f.servid=:servid").setString("frandid",frands.getFrandid()).setString("servid",frands.getServid()).list();
        return lfr.size()!=0;
    }

    @Override
    public boolean isAddFrandsToUser(Frands frands) {
        List<Frands> lfr=getSession().createQuery("FROM "+getPersistentClass().getName()+" f WHERE f.frandid=:frandid and f.servid=:servid and f.userid=:userid").setString("userid",frands.getUserid()).setString("frandid",frands.getFrandid()).setString("servid",frands.getServid()).list();
        return lfr.size()!=0;
    }
}

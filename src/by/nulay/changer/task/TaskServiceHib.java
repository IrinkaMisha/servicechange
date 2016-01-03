package by.nulay.changer.task;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rw.gcktc.cms.nodedata.service.hib.GenericHibernateDAO;
import rw.gcktc.cms.nodedata.service.hib.ServiceHib;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miha
 * Date: 22.10.14
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */

@Transactional(readOnly = true)
public class TaskServiceHib<T extends Task,ID extends Number> extends GenericHibernateDAO<T,ID> implements TaskService<T,ID> {
    private static Logger log= Logger.getLogger(TaskServiceHib.class);

    @Override
    public List<T> getTasks(Boolean perform, String executor) {
        String strsql="";
        if(perform!=null){
            strsql+="performed=:perform";
        }
        if(executor!=null){
            if(!strsql.equals("")){
                strsql+=" AND ";
            }
            strsql+="executor=:executor";
        }
        if(!strsql.equals("")){
            strsql+=" WHERE ";
        }
        Query q=getSession().createQuery("FROM "+getPersistentClass().getName()+strsql);
        if(perform!=null){
            q.setBoolean("performed", perform);
        }
        if(executor!=null){
            q.setString("executor",executor);
        }
        return q.list();
    }

    @Override
    @Transactional
    public T addOrChangeTask(T task) {
        Date d=task.getDateexecution();
        task.setDateexecution(null);
        List<Task> lT= (List<Task>) getByExample(task);
        if(lT.size()>0){
            for(Task t:lT){
                delete((T) t);
            }
        }
        task.setDateexecution(d);
        saveOrUpdate(task);
        return task;
    }

    @Override
    public T getNextTask(String executor) {
        return (T) getSession().createQuery("FROM " + getPersistentClass().getName() + " WHERE executor=:executor AND performed=0 AND dateexecution<:dateE")
                .setTimestamp("dateE", new Date()).setString("executor",executor).setMaxResults(1).uniqueResult();
    }

    @Override
    public boolean checkPerform(T task) {
        return task.getPerformed();
    }

    @Override
    public boolean checkPerform(ID id_job) {
        T task = getById(id_job, false);
        return task.getPerformed();
    }

    @Override
    @Transactional
    public boolean markComleted(T task) {
        task.setPerformed(true);
        saveOrUpdate((T) task);
        return task.getPerformed();
    }

    @Override
    @Transactional
    public boolean markComleted(ID id_job) {
        T task = getById(id_job, true);
        task.setPerformed(true);
        task.setPerformedStatus(1);
        saveOrUpdate(task);
        return task.getPerformed();
    }

    @Override
    @Transactional
    public boolean setPerformedStatus(ID id_job,Integer status) {
        T task = getById(id_job, true);
        task.setPerformedStatus(status);
        saveOrUpdate(task);
        return true;
    }

    @Override
    public Task getTaskForPage(String pageName, String executor) {
        return (T) getSession().createQuery("FROM " + getPersistentClass().getName() + " WHERE executor=:executor AND pageName=:pageName AND performed=0 AND dateexecution<:dateE")
                .setTimestamp("dateE", new Date()).setString("executor",executor).setString("pageName",pageName).setMaxResults(1).uniqueResult();
    }
}

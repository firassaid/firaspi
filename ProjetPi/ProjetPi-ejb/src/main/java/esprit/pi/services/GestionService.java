package esprit.pi.services;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.pi.entity.Event;


@Stateless
public class GestionService implements IRemoteGestionService {

	
	@PersistenceContext
	EntityManager em ;
	
	@Override
	public void ajouterService(Event service) {
		em.persist(service);
	}

	@Override
	public void supprimerService(Event service) {
		em.remove(em.merge(service));
	}

	@Override
	public void modifierService(Event service) {

		em.merge(service);
	}
	public List<Event> getServices() {
		TypedQuery<Event> query = em.createQuery("select h from Event h", Event.class);
	
		return query.getResultList();
	}
	public Event getServiceByName(String nom) {
		TypedQuery<Event> query = em.createQuery("select h from Event h where h.nom=:nom", Event.class);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}
	public Event getServiceById(int id) {
		TypedQuery<Event> query = em.createQuery("select h from Event h where h.id=:id", Event.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}


	@Override
	public List<Event> getS() {
TypedQuery<Event> query = em.createQuery("select h from Event h", Event.class);
		
		return query.getResultList();
	}
@Override
	public Long CountS(String type) {
		Query  query = em.createQuery("select count(d) from Event d where d.type=:type  ");
		query.setParameter("type", type);
		return (long)query.getSingleResult();
	}
@Override
public Event suppServiceByName(String description) {
	TypedQuery<Event> query = em.createQuery("delete h from Event h where h.description=:description", Event.class);
	//query.setParameter("description", description);
	return query.getSingleResult();

}

public List<Event> findAll() {
	Query query = em.createQuery("select  p from Event p");
	return query.getResultList();
}



}

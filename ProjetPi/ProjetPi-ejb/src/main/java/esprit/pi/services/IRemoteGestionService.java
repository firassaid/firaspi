package esprit.pi.services;


import java.util.List;

import javax.ejb.Remote;

import esprit.pi.entity.Event;


@Remote
public interface IRemoteGestionService {

	void ajouterService(Event service);

	void supprimerService(Event service);

	void modifierService(Event service);
	List <Event > findAll();
	Event suppServiceByName(String description);
	List<Event> getServices();
	
	Event getServiceByName(String nom);

	List<Event> getS();

	Long CountS(String type);
	
	Event getServiceById(int id);

}

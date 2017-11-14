
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import esprit.pi.entity.Event;
import esprit.pi.services.IRemoteGestionService;


@ManagedBean
@SessionScoped


public class ServiceBean {
	  private Event SelectedSS;
      private Boolean renderReserver=false;
      private String nom;
      private float taux;

  	private String type;
        private String lieu;
        private int duree;
        private Date Date_Debut;
      
      
      public List< Event> getJOF() {
  		return JOF;
  	}

  	public void setJOF(List< Event> jOF) {
  		JOF = jOF;
  	}

  	public Event getSelectedSS() {
  		return SelectedSS;
  	}

  	public void setSelectedSS(Event selectedSS) {
  		SelectedSS = selectedSS;
  	}

  	public Boolean getRenderReserver() {
  		return renderReserver;
  	}

  	public void setRenderReserver(Boolean renderReserver) {
  		this.renderReserver = renderReserver;
  	}

  	public String getNom() {
  		return nom;
  	}

  	public void setNom(String nom) {
  		this.nom = nom;
  	}

  	public String getDescription() {
  		return Description;
  	}

  	public void setDescription(String description) {
  		Description = description;
  	}
      public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	private int prix;
      
      
      public ServiceBean() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Date getDate_Debut() {
		return Date_Debut;
	}

	public void setDate_Debut(Date date_Debut) {
		Date_Debut = date_Debut;
	}

      
      public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	private String Description;
	private Event SS = new Event ();
	@EJB
	IRemoteGestionService GSService ;
	  private List< Event> JOF = new ArrayList<Event>() ;
	  private List< Event>  filteredService= new ArrayList<Event>() ;
	
	public List<Event> getFilteredService() {
		return filteredService;
	}

	public void setFilteredService(List<Event> filteredService) {
		this.filteredService = filteredService;
	}

	public String CreateService() {
		  GSService.ajouterService(SS);
		  return null;
		}

	@PostConstruct
	 public void init(){
		 JOF=GSService.findAll();
	
		}
	 
	 public void modif( ){
		 SelectedSS.setNom(nom);
		 SelectedSS.setDescription(Description);
		 SelectedSS.setPrix(prix);
		 SelectedSS.setLieu(lieu);
		 SelectedSS.setDate_Debut(Date_Debut);
		 SelectedSS.setDuree(duree);
		 
		 GSService.modifierService(SelectedSS);
		 init();
		 
	 }

		public String CreateUser() {
			 SS.setDescription(Description);
			
			 SS.setNom(nom);
			SS.setType(type);
			
		SS.setLieu(lieu);
		
		//if(SS.getDate_Debut().getDay()
//		Date d = new Date();
//		d.setDate(Date_Debut.getDay());
//		d.setMonth(Date_Debut.getMonth());
//		d.setYear(Date_Debut.getYear());
//			SS.setDate_Debut(d);
		SS.setDate_Debut(Date_Debut);
		int s=Date_Debut.getDay();
		SS.setPrix(prix);
		if((s==6)||(s==7))
		{
			 SS.setPrix(prix+50);
		}
		
		
		SS.setDuree(duree);
			
			
			
			//Event.setIsAvailable(isAvailable);
			  GSService.ajouterService(SS);
			 init();
			  return "/Admin/Filtrage?faces-redirect=true";
			}
	 public String Delete(Event SelectedSS){
			GSService.supprimerService(SelectedSS);
			init();
			return null;	
		}
	 
	 
	 
	 
	 
	 
	 
	 public void calculer()
	 {		//init();
	 			
	 					
	 	//for(int i=0;i<deals.size();i++){
	 		//nom=deals.get(i).getSous_service().getDescription();
	 		//deals.get(i).setNom(nom);
	 		//gd.modifierDeal(deals.get(i));
	 		
	 	//}
	 					
	 			//for(int i=0;i<dealsDate.size();i++){
	 				
	 				//float pri=dealsDate.get(i).getPrix();
	 				//dealsDate.get(i).setPrix(pri+20);
	 				//setNom(dealsDate.get(i).getSous_service().getNom());
	 				//nom=dealsDate.get(i).getSous_service().getDescription();
	 				//dealsDate.get(i).setNom("cc");
	 				
	 				//gd.modifierDeal(dealsDate.get(i));
	 				
	 		//	}
	 			
	 		
	 	}
	 			
	 
	 
	 
	 
	 
	 
	 
	
	
}
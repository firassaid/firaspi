

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import esprit.pi.entity.Event;
import esprit.pi.services.IRemoteGestionService;



@ManagedBean(name="OfferC")
public class OfferC {
	private PieChartModel pieModel1;
	 @EJB
	 IRemoteGestionService gd;
	 private List<Event> SS = new ArrayList<Event>();
	    @PostConstruct
	    public void init() {
	        createPieModels();
	    }
	 
	    public PieChartModel getPieModel1() {
	        return pieModel1;
	    }
	     
	    
	     
	    private void createPieModels() {
	        createPieModel1();
	    }
	 

	    
	    
	    private void createPieModel1() {
		    
		    	SS=gd.getS();
		    	 pieModel1 = new PieChartModel();
		    	//for (int i=0; i<SS.size(); i++){
		    	for(Event SS :gd.getS()){
		       
		         
		        pieModel1.set(SS.getType(), gd.CountS(SS.getType()));
		        
		        //pieModel1.set("Refused", gd.CalculeEtatRefused());
		        pieModel1.setTitle("My Statistics!");
		        pieModel1.setLegendPosition("w");
		    	}
		    
		    }
	    
	    
		public List<Event> getSS() {
			return SS;
		}

		public void setSS(List<Event> sS) {
			SS = sS;
		}

		
}
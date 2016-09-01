package market.dataanalysistool.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import market.dataanalysistool.jpa.Market;
import market.dataanalysistool.jpa.Sample;

/**
 * Session Bean implementation class SampleSessionBean
 */
@Stateless
@Remote(StockDataRemote.class)
@Local(StockDataLocal.class)
public class SampleSessionBean implements StockDataRemote, StockDataLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(name="MarketDataAnalysisToolJPA")
	EntityManager em;
	
    public SampleSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Sample getSample() {
		// TODO Auto-generated method stub
		String sql = "SELECT s FROM Sample AS s";
        TypedQuery<Sample> query = em.createQuery(sql, Sample.class);

        // Execute the query, and get a collection of products back.
//        
//        query.setMaxResults(1);
//        Sample samples =query.getSingleResult();
        List<Sample> sampleList=query.getResultList();
        Sample samples= sampleList.get(sampleList.size()-1);
        
		return samples;
	}
////
	public Sample getParticularSample(long serialNo) {
		// TODO Auto-generated method stub
		String sql = "SELECT s FROM Sample AS s WHERE s.serialNo= :theSerialNo";
		
        TypedQuery<Sample> query = em.createQuery(sql, Sample.class);
        query.setParameter("theSerialNo",serialNo);
        // Execute the query, and get a collection of products back.
        query.setMaxResults(1);
        Sample samples =query.getSingleResult();
        //Sample result = samples.get(1);
		return samples;
	}

	@Override
	public void setSample(String sample) {
		// TODO Auto-generated method stub
//		String str=sample;
//		 String query1 = "insert into users values('" + str  +"')";
//		    Query q = em.createQuery(query1);
		Sample ob = new Sample();
		ob.setSample(sample);
		em.persist(ob);
	}
	
	
//	public void setSample(Sample sample) {
//		// TODO Auto-generated method stub
////		String str=sample;
////		 String query1 = "insert into users values('" + str  +"')";
////		    Query q = em.createQuery(query1);
//		Sample ob = new Sample();
//		ob.setSample(sample);
//		em.persist(ob);
//	}
	public void getObject(Sample t){
		System.out.println(t.getSample());
		
	}

	@Override
	public List<Market> getPriceTrendByTime(String string, PeriodOfTime year) {
		// TODO Auto-generated method stub
		return null;
	}
}

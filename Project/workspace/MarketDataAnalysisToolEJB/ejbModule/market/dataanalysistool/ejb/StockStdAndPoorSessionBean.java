package market.dataanalysistool.ejb;

<<<<<<< Updated upstream
import java.util.Date;
import java.util.Map;
=======
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
>>>>>>> Stashed changes

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
<<<<<<< Updated upstream

import market.dataanalysistool.jpa.MarketPK;
=======
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import market.dataanalysistool.jpa.CloseValueAndDate;
import market.dataanalysistool.jpa.Market;
import market.dataanalysistool.jpa.TickerCloseValues;

>>>>>>> Stashed changes

/**
 * Session Bean implementation class StockStdAndPoorSessionBean
 */
@Stateless
@Remote(StockStdAndPoorSessionBeanRemote.class)
@Local(StockStdAndPoorSessionBeanLocal.class)
public class StockStdAndPoorSessionBean implements StockStdAndPoorSessionBeanRemote, StockStdAndPoorSessionBeanLocal {

<<<<<<< Updated upstream
    /**
     * Default constructor. 
     */
    public StockStdAndPoorSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Map<Date, Double> getSimpleMovingAverages(MarketPK stock, int timePeriod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Date, Double> getExponentialMovingAverages(MarketPK stock, int timePeriod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Date, Double> getPriceTrendByTime(MarketPK stock, PeriodOfTime timePeriod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Date, Double> getVolumeTrendByTime(MarketPK stock, PeriodOfTime timePeriod) {
		// TODO Auto-generated method stub
		return null;
	}

=======
	/**
	 * Default constructor.
	 */

	@PersistenceContext(name = "MarketDataAnalysisToolJPA")
	EntityManager em;

	public StockStdAndPoorSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TickerCloseValues getPriceTrendByTime(String ticker, PeriodOfTime timePeriod){
		// TODO Auto-generated method stub

		// validation of date
		// setting of start and end dates for the query
		Date startDate;
		Date endDate;
		Calendar cal = Calendar.getInstance();
		TickerCloseValues tickerCloseValues = new TickerCloseValues();
		
		switch (timePeriod) {

		case YEAR:
			//SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			
			cal.set(2009, 02, 31, 0, 0, 0);
			startDate = cal.getTime();
			cal.set(2010, 03, 1, 0, 0, 0);
			endDate = cal.getTime();
			System.out.println("in year");
			//System.out.println("Start date is :" + startDate);
			//System.out.println("End date is :" + endDate);

			break;

		case SIXMONTHS:
			cal.set(2009, 03, 1, 0, 0, 0);
			startDate = cal.getTime();
			cal.set(2009,9, 31, 0, 0, 0);
			endDate = cal.getTime();
			System.out.println("in half year");
			break;

		case FIRSTQUARTER:
			cal.set(2009, 03, 1, 0, 0, 0);
			startDate = cal.getTime();
			cal.set(2009,5, 30, 0, 0, 0);
			endDate = cal.getTime();
			System.out.println("in first quarter");
			break;

		case SECONDQUARTER:
			cal.set(2009, 06, 1, 0, 0, 0);
			startDate = cal.getTime();
			cal.set(2009, 8, 30, 0, 0, 0);
			endDate = cal.getTime();
			System.out.println("in second quarter");
			break;

		case THIRDQUARTER:
			cal.set(2009, 9, 1, 0, 0, 0);
			startDate = cal.getTime();
			cal.set(2009,11, 31, 0, 0, 0);
			endDate = cal.getTime();
			System.out.println("in third quarter");
			break;

		case LASTQUARTER:
			cal.set(2009, 11, 31, 0, 0, 0);
			startDate = cal.getTime();
			cal.set(2010, 4, 1, 0, 0, 0);
		
			
			endDate = cal.getTime();
			System.out.println("in last quarter");
			startDate = new Date(2009 - 04 - 01);
			endDate = new Date();
			break;

		// case FORTNIGHT :
		// startDate = new Date(2009-04-01);
		// endDate = new Date();
		// break;
		//
		// case WEEK :
		// startDate = new Date(2009-04-01);
		// endDate = new Date();
		// break;
		//
		// case DAY :
		// startDate = new Date(2009-04-01);
		// endDate = new Date();
		// break;

		default:
			cal.set(2009, 03, 1, 0, 0, 0);
			startDate = cal.getTime();
			cal.set(2010, 2, 31, 0, 0, 0);
			endDate = cal.getTime();
			System.out.println("in default case");
		}

		System.out.println("Start date is :" + startDate);
		System.out.println("End date is :" + endDate);

		//generating query on database
		@SuppressWarnings("unchecked")
		TypedQuery<Object[]> query = (TypedQuery<Object[]>) em
				.createQuery("SELECT m.close_,m.id.x_Date FROM Market m  WHERE m.id.ticker_ = '" + ticker
						+ "' and m.id.x_Date BETWEEN :startDate AND :endDate")
				.setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE);
		List<Object[]> instances =(List<Object[]>) query.getResultList();
		
		
		System.out.println("1111");
		System.out.println(instances.size());
		System.out.println("2222");
		//return instances;
		
		tickerCloseValues.setStockCloseValueList(instances);
		tickerCloseValues.setStartDate(startDate.toString());
		tickerCloseValues.setStartDate(endDate.toString());
		tickerCloseValues.setTicker(ticker);
		
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		String json = ow.writeValueAsString(object);
		
//		try{
//			obj.put("StockCloseValueList", tickerCloseValues.getStockCloseValueList());
//			obj.put("StartDate", tickerCloseValues.getStartDate());
//			obj.put("EndDate", tickerCloseValues.getEndDate());
//			obj.put("Ticker", tickerCloseValues.getTicker());
//		}
//		catch(Exception e){
//			
//		}
		
		
		return tickerCloseValues;
	}

	@Override
	public List<Market> getVolumeTrendByTime(String ticker, PeriodOfTime timePeriod) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Market> getAllStocks() {
		String sql = "SELECT m FROM Market AS m";
		TypedQuery<Market> query = em.createQuery(sql, Market.class);

		// Execute the query, and get a collection of products back.
		List<Market> samples = query.getResultList();
		return samples;
	}

	/*
	 * @Override public Map<String, BigDecimal> getSimpleMovingAverages(MarketPK
	 * stock, int timePeriod, PeriodOfTime t) { String sql =
	 * "SELECT m FROM Market AS m WHERE m.id = " + stock; TypedQuery<Market>
	 * query = em.createQuery(sql, Market.class);
	 * 
	 * // Execute the query, and get a collection of products back. List<Market>
	 * samples = query.getResultList(); int i = 0; Map<String,BigDecimal> result
	 * = new HashMap<String,BigDecimal>(); for (Market ob : samples) {
	 * result.put(ob.getId().getDate(), ob.getHigh()); } // while
	 * (sampleSet.iterator().hasNext()) { // if (sampleSet.size() <=
	 * i+timePeriod) { // break; // } // double avg =
	 * getAverageOfList(sampleSet.subList(i, i+timePeriod)); //
	 * result.put((Date)(sampleSet.get(i)[0]),avg); // i++; // } return null;
	 * //return result; }
//	 */
//	public double getAverageOfList(List<Market> x) {
//		Double avg = (double) 0;
//		for (Market a : x) {
//			avg = avg + (Double) a.getClose_();
//		}
//		avg = avg / (x.size());
//		return avg;
//	}

	@Override
	public List<Point> getExponentialMovingAverages(String ticker, int timePeriod, PeriodOfTime t) {
		// TODO Auto-generated method stub
		
		return null;
	}

//	@Override
//	public List<Point> getSimpleMovingAverages(String ticker, int timePeriod, PeriodOfTime t) {
//		// TODO Auto-generated method stub
//		List<TickerCloseValues> sampleSet = this.getPriceTrendByTime(ticker, t);
//		int i = 0;
//		
//		List<Point> result = new ArrayList<Point>();
//		while(timePeriod < sampleSet.size()) {
//			Point ob = new Point();
//			List<TickerCloseValues> smaSet = sampleSet.subList(i, timePeriod);
//			ob.setDate(smaSet.get(9).getId().getX_Date());
//			ob.setyCoordinate(getAverageOfList(smaSet));
//			result.add(ob);
//			i++;
//			timePeriod++;
//		}
//		return result;
//	}

	@Override
	public List<Object[]> getAllTickers() {
		@SuppressWarnings("unchecked")
		TypedQuery<Object[]> query = (TypedQuery<Object[]>) em
				.createQuery("SELECT DISTINCT m.id.ticker_ FROM Market m");
		
		List<Object[]> result= query.getResultList();
		
		System.out.println(result.size());
		
		return result;	
	}

	@Override
	public List<Point> getSimpleMovingAverages(String ticker, int timePeriod, PeriodOfTime t) {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> Stashed changes
}

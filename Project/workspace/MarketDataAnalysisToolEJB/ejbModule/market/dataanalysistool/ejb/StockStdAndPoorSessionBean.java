package market.dataanalysistool.ejb;

import java.util.Date;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import market.dataanalysistool.jpa.MarketPK;

/**
 * Session Bean implementation class StockStdAndPoorSessionBean
 */
@Stateless
@Remote(StockStdAndPoorSessionBeanRemote.class)
@Local(StockStdAndPoorSessionBeanLocal.class)
public class StockStdAndPoorSessionBean implements StockStdAndPoorSessionBeanRemote, StockStdAndPoorSessionBeanLocal {

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

}

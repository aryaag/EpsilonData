package market.dataanalysistool.ejb;

import java.util.Date;
import java.util.Map;
import javax.ejb.Local;
import market.dataanalysistool.jpa.MarketPK;
/*
 * This interface details the list of methods that can be implemented on the database of the S&P 500
 */
@Local
public interface StockStdAndPoorSessionBeanLocal {
	public Map<Date,Double> getSimpleMovingAverages(MarketPK stock, int timePeriod);
	public Map<Date,Double> getExponentialMovingAverages(MarketPK stock, int timePeriod);
	public Map<Date,Double> getPriceTrendByTime(MarketPK stock, PeriodOfTime timePeriod);
	public Map<Date,Double> getVolumeTrendByTime(MarketPK stock, PeriodOfTime timePeriod);
}

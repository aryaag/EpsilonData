package market.dataanalysistool.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import market.dataanalysistool.ejb.PeriodOfTime;
//import market.dataanalysistool.ejb.Point;
import market.dataanalysistool.ejb.StockStdAndPoorSessionBeanRemote;
//import market.dataanalysistool.jpa.CloseValueAndDate;
//import market.dataanalysistool.jpa.Market;
import market.dataanalysistool.jpa.TickerCloseValues;

@RequestScoped
@Path("/test")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class firstfunction {
	
	StockStdAndPoorSessionBeanRemote bean;
	Context context;

	
	public firstfunction() {
		try {
			context = new InitialContext();
			bean = (StockStdAndPoorSessionBeanRemote)context.lookup("java:app/MarketDataAnalysisToolEJB/StockStdAndPoorSessionBean!market.dataanalysistool.ejb.StockStdAndPoorSessionBeanRemote");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Path("/string")
	
	@GET
	@Produces("text/plain")
	public String xyz(){
		return ("Hello!");
	}
//	@GET
//	@Produces("application/json")
//	public TickerCloseValues getAllProducts(@QueryParam("filter") @DefaultValue("") String filter) {
//		return bean.getPriceTrendByTime("A", PeriodOfTime.YEAR);
//	}
//	
	@GET
	@Path("/simpleAvg")
//	@Produces("application/json")
	@Produces("text/plain")
	public String getSimpleMovingAverages() {
//		return bean.getSimpleMovingAverages("A", 10, PeriodOfTime.YEAR);
		return "returned test";
	}
	
	@GET
	@Path("/allTickers")
	@Produces("application/json") 
	public List<Object[]> getAllTickers() {
		return bean.getAllTickers();
	}

}

/**
 * 
 */
package com.huatai.cube.rms.modules.mktquotation.Help;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htsc.mdc.model.ESecurityTypeProtos.ESecurityType;
import com.htsc.mdc.model.MDForexRecordProtos.MDForexRecord;
import com.htsc.mdc.model.MDFundRecordProtos.MDFundRecord;
import com.htsc.mdc.model.MDFutureRecordProtos.MDFutureRecord;
import com.htsc.mdc.model.MDIndexRecordProtos.MDIndexRecord;
import com.htsc.mdc.model.MDSecurityRecordProtos.MDSecurityRecord;
import com.htsc.mdc.model.MDStockRecordProtos.MDStockRecord;
import com.htsc.mdc.query.service.QueryRealTimeDataService;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModel;
import com.huatai.cube.rms.modules.parameter.model.UnderlyingModel;
import com.huatai.cube.rms.util.CommonUtils;

/**取A股，期货实时行情
 * @author 006562
 *
 */
@Service
public class TimeDataServiceHelper {
	
	private TimeDataServiceHelper() {
		
	}
	
	@Autowired
	private  QueryRealTimeDataService queryRealTimeDataService;
	
	public void setQueryRealTimeDataService(QueryRealTimeDataService queryRealTimeDataService) {
		this.queryRealTimeDataService = queryRealTimeDataService;
	}
	/**
	 * 从行情中心取实时行情（A股票）
	 *
	 * @param SecurityID
	 * @param ExchangeCode
	 * @return Stock
	 */
	public LivePriceModel getTimeData(UnderlyingModel model){
		LivePriceModel price = new LivePriceModel();
		price.setUnderlying(model.getUnderlying());
		price.setCurrency(model.getCurrency());
		price.setExchangecode(model.getExchangecode());
		if(model.getExchangecode().equals("SH")||model.getExchangecode().equals("SZ")||model.getExchangecode().equals("HK")
				||model.getExchangecode().equals("MORN")||model.getExchangecode().equals("FX")) {
			if(model.getExchangecode().equals("FX"))
				model.setUnderlying(model.getUnderlying()+".MORN");
			MDSecurityRecord stockBySource = queryRealTimeDataService.getSecurity(model.getUnderlying()).getResult();//证券数据
			//012737 2018/2/10 测试发现，当model.getUnderlying()==6158.HK时，stockBySource为null，所以增加容错判断。
			if (stockBySource != null) {
				if (stockBySource.getSecurityType().equals(ESecurityType.IndexType)) {
					MDIndexRecord stock = stockBySource.getMDIndex();
					price.setStopflag(stock.getTradingPhaseCode().equals("8") ? false : true);
					if (price.getStopflag()) {
						price.setLast(CommonUtils.convertDouble(stock.getLastPx()));
						if (compareZero(stock.getClosePx())) {
							price.setClose(CommonUtils.convertDouble(stock.getLastPx()));
						} else {
							price.setClose(CommonUtils.convertDouble(stock.getClosePx()));
						}
					} else {
						price.setClose(CommonUtils.convertDouble(stock.getPreClosePx()));
						price.setLast(CommonUtils.convertDouble(stock.getPreClosePx()));
					}
					price.setHigh(CommonUtils.convertDouble(stock.getHighPx()));
					price.setLow(CommonUtils.convertDouble(stock.getLowPx()));
					price.setOpen(CommonUtils.convertDouble(stock.getOpenPx()));

				} else if (stockBySource.getSecurityType().equals(ESecurityType.StockType)) {
					MDStockRecord stock = stockBySource.getMDStock();
					price.setStopflag(stock.getTradingPhaseCode().equals("8") ? false : true);
					if (price.getStopflag()) {
						price.setLast(CommonUtils.convertDouble(stock.getLastPx()));
						if (compareZero(stock.getClosePx())) {
							price.setClose(CommonUtils.convertDouble(stock.getLastPx()));
						} else {
							price.setClose(CommonUtils.convertDouble(stock.getClosePx()));
						}
					} else {
						price.setClose(CommonUtils.convertDouble(stock.getPreClosePx()));
						price.setLast(CommonUtils.convertDouble(stock.getPreClosePx()));
					}
					price.setHigh(CommonUtils.convertDouble(stock.getHighPx()));
					price.setLow(CommonUtils.convertDouble(stock.getLowPx()));
					price.setOpen(CommonUtils.convertDouble(stock.getOpenPx()));

				} else if (stockBySource.getSecurityType().equals(ESecurityType.FundType)) {
					MDFundRecord stock = stockBySource.getMDFund();
					price.setStopflag(stock.getTradingPhaseCode().equals("8") ? false : true);
					if (price.getStopflag()) {
						price.setLast(CommonUtils.convertDouble(stock.getLastPx()));
						if (compareZero(stock.getClosePx())) {
							price.setClose(CommonUtils.convertDouble(stock.getLastPx()));
						} else {
							price.setClose(CommonUtils.convertDouble(stock.getClosePx()));
						}
					} else {
						price.setClose(CommonUtils.convertDouble(stock.getPreClosePx()));
						price.setLast(CommonUtils.convertDouble(stock.getPreClosePx()));
					}
					price.setHigh(CommonUtils.convertDouble(stock.getHighPx()));
					price.setLow(CommonUtils.convertDouble(stock.getLowPx()));
					price.setOpen(CommonUtils.convertDouble(stock.getOpenPx()));
				} else if (stockBySource.getSecurityType().equals(ESecurityType.FuturesType)){
					MDFutureRecord stock = stockBySource.getMDFuture();//期货模型
					//012737 2018/2/10 增加容错判断。
					if (stock != null) {
						price.setStopflag(stock.getTradingPhaseCode().equals("8") ? false : true);
						if (price.getStopflag()) {
							price.setLast(CommonUtils.convertDouble(stock.getLastPx()));
							if (compareZero(stock.getClosePx())) {
								price.setClose(CommonUtils.convertDouble(stock.getLastPx()));
							} else {
								price.setClose(CommonUtils.convertDouble(stock.getClosePx()));
							}
						} else {
							price.setClose(CommonUtils.convertDouble(stock.getPreClosePx()));
							price.setLast(CommonUtils.convertDouble(stock.getPreClosePx()));
						}
						price.setHigh(CommonUtils.convertDouble(stock.getHighPx()));
						price.setLow(CommonUtils.convertDouble(stock.getLowPx()));
						price.setOpen(CommonUtils.convertDouble(stock.getOpenPx()));
					}
				} else if (stockBySource.getSecurityType().equals(ESecurityType.ForexType)){
					MDForexRecord stock = stockBySource.getMDForex();
					if (stock != null) {
						price.setStopflag(stock.getTradingPhaseCode().equals("8") ? false : true);
						if (price.getStopflag()) {
							price.setLast(CommonUtils.convertDouble(stock.getLastPx()));
							if (compareZero(stock.getClosePx())) {
								price.setClose(CommonUtils.convertDouble(stock.getLastPx()));
							} else {
								price.setClose(CommonUtils.convertDouble(stock.getClosePx()));
							}
						} else {
							price.setClose(CommonUtils.convertDouble(stock.getPreClosePx()));
							price.setLast(CommonUtils.convertDouble(stock.getPreClosePx()));
						}
						price.setHigh(CommonUtils.convertDouble(stock.getHighPx()));
						price.setLow(CommonUtils.convertDouble(stock.getLowPx()));
						price.setOpen(CommonUtils.convertDouble(stock.getOpenPx()));
					}
				}
			}
		}
		if(model.getExchangecode().equals("SHF")||model.getExchangecode().equals("CFFEX")||model.getExchangecode().equals("CZCE")||model.getExchangecode().equals("DCE")){
			MDFutureRecord stock = queryRealTimeDataService.getSecurity(model.getUnderlying()).getResult().getMDFuture();//期货模型
			//012737 2018/2/10 增加容错判断。
			if (stock != null) {
				price.setStopflag(stock.getTradingPhaseCode().equals("8") ? false : true);
				if (price.getStopflag()) {
					price.setLast(CommonUtils.convertDouble(stock.getLastPx()));
					if (compareZero(stock.getClosePx())) {
						price.setClose(CommonUtils.convertDouble(stock.getLastPx()));
					} else {
						price.setClose(CommonUtils.convertDouble(stock.getClosePx()));
					}
				} else {
					price.setClose(CommonUtils.convertDouble(stock.getPreClosePx()));
					price.setLast(CommonUtils.convertDouble(stock.getPreClosePx()));
				}
				price.setHigh(CommonUtils.convertDouble(stock.getHighPx()));
				price.setLow(CommonUtils.convertDouble(stock.getLowPx()));
				price.setOpen(CommonUtils.convertDouble(stock.getOpenPx()));
			}
		}
		
		return price;
	}
	
	private Boolean compareZero(Double i) {
		BigDecimal x = BigDecimal.valueOf(i);
		return x.compareTo(BigDecimal.ZERO) == 0;
	}
	
}


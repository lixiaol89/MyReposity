/**
 * 
 */
package com.huatai.cube.rms.modules.mktquotation.business;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatai.cube.rms.modules.mktquotation.dao.HisPriceModelMapper;
import com.huatai.cube.rms.modules.mktquotation.dao.LivePriceModelMapper;
import com.huatai.cube.rms.modules.mktquotation.model.HisPriceModel;
import com.huatai.cube.rms.modules.mktquotation.model.HisPriceModelExample;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModel;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModelExample;

/**
 * @author 006562
 *
 */
@Service
public class HisPriceHandler {
	@Resource(name="livePriceModelMapper")
	LivePriceModelMapper livePriceModelMapper;
	@Resource(name="hisPriceModelMapper")
	HisPriceModelMapper hisPriceModelMapper;
	
	/**
	 * 归档行情
	 * 
	 * */
	public void file() {
		LivePriceModelExample priceModelExample = new LivePriceModelExample();
		List<LivePriceModel> livelist = livePriceModelMapper.selectByExample(priceModelExample);
		for(LivePriceModel livePriceModel : livelist){
			HisPriceModel hisPriceModel = liveTohis(livePriceModel);
			HisPriceModelExample example = new HisPriceModelExample();
			example.or().andHisdateEqualTo(hisPriceModel.getHisdate()).andCurrencyEqualTo(hisPriceModel.getCurrency()).andExchangecodeEqualTo(hisPriceModel.getExchangecode()).andUnderlyingEqualTo(hisPriceModel.getUnderlying());
			if (0 == hisPriceModelMapper.countByExample(example)) {
				if (livePriceModel.getLast() == BigDecimal.ZERO) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(livePriceModel.getNowdate());
					calendar.add(Calendar.DAY_OF_MONTH, -1);
					HisPriceModelExample example1 = new HisPriceModelExample();
					example1.or().andHisdateEqualTo(calendar.getTime()).andCurrencyEqualTo(hisPriceModel.getCurrency()).andExchangecodeEqualTo(hisPriceModel.getExchangecode()).andUnderlyingEqualTo(hisPriceModel.getUnderlying());
					List<HisPriceModel> model = hisPriceModelMapper.selectByExample(example1);
					hisPriceModel.setLast(model.get(0).getLast());
					hisPriceModel.setClose(model.get(0).getClose());
				}
				hisPriceModelMapper.insert(hisPriceModel);
			}
		}
	}
	private HisPriceModel liveTohis(LivePriceModel model){
		HisPriceModel uIModel = new HisPriceModel();
		uIModel.setHisdate(model.getNowdate());
		uIModel.setCurrency(model.getCurrency());
		uIModel.setExchangecode(model.getExchangecode());
		uIModel.setStopflag(model.getStopflag());
		uIModel.setUnderlying(model.getUnderlying());
		uIModel.setLast(model.getLast());
		uIModel.setClose(model.getClose());
		uIModel.setOpen(model.getOpen());
		uIModel.setHigh(model.getHigh());
		uIModel.setLow(model.getLow());
		uIModel.setSettleprice(model.getSettleprice());
		return uIModel;
		
	}
	
}

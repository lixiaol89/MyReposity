package datasource;

public class ExcuteDataCompare {
//	
//	public <T> T getsource( Class<T> t){
//		SqlSessionFactory factory = GetDataSource.getSqlSessionFactory(DataSourceEnvironment.development);
//		SqlSession session = factory.openSession(true);
//		T sourceMapper = session.getMapper(t);
//		return sourceMapper;
//	}
//	
//	/*public static void main(String[] args) {
//		ExcuteDataCompare compare = new ExcuteDataCompare();
//		BarrieroptbkinfoModelMapper n = compare.getsource(BarrieroptbkinfoModelMapper.class);
//		List<BarrieroptbkinfoModel> list = n.selectByExample(null);
//		System.out.println(list.size());
//	}*/
//	
//	
//	
//	public static void main(String[] args) {
//	/*	SqlSessionFactory factory = GetDataSource.getSqlSessionFactory(DataSourceEnvironment.development);
//		SqlSession sessiondevelopment = factory.openSession(true);
//		
//		SqlSessionFactory factory1 = GetDataSource.getSqlSessionFactory(DataSourceEnvironment.qa);
//		SqlSession sessionqa = factory1.openSession(true);*/
//		
//		
//		BarrieroptbkinfoModelMapper  sourceMapper = GetDataSource.getdatasource(BarrieroptbkinfoModelMapper.class, DataSourceEnvironment.development);
//		BarrieroptbkinfoModelMapper  targetMapper = GetDataSource.getdatasource(BarrieroptbkinfoModelMapper.class, DataSourceEnvironment.qa);
//		
//		
////		BarrieroptbkinfoModelMapper sourceMapper = sessiondevelopment.getMapper(BarrieroptbkinfoModelMapper.class);
//		List<BarrieroptbkinfoModel> listsource = sourceMapper.selectByExample(null);
//		
////		BarrieroptbkinfoModelMapper targetMapper = sessionqa.getMapper(BarrieroptbkinfoModelMapper.class);
//		List<BarrieroptbkinfoModel> listtarget = targetMapper.selectByExample(null);
//		
//		List<BarrieroptbkinfoModel> same = new ArrayList<BarrieroptbkinfoModel>();
//		for(BarrieroptbkinfoModel modeltarget :listtarget){
//			 for(BarrieroptbkinfoModel modelsource : listsource){
//				 int result = modeltarget.compareTo(modelsource);
//				 if(result == 0){
//					 same.add(modeltarget);
//					 break;
//				 }
//			 }
//		}
//		
//		System.out.println("listsource"+listsource.size());
//		System.out.println("listtarget"+listtarget.size());
//		
//		System.out.println("same"+same.size());
//		for(BarrieroptbkinfoModel model : same){
//			System.out.println(model.getTradeid());
//		}
//		
//		
//		listtarget.removeAll(same);//targetdiff
//		System.out.println("listtarget"+listtarget.size());
//		for(BarrieroptbkinfoModel model : same){
//			System.out.println(model.getTradeid());
//		}
//
//		
////		targetMapper.deleteByExample(null);
//		
////		System.out.println(targetMapper.selectByExample(null).size());
////		
////		for(DataMoveTestModel samemodel:listsource){
////			System.out.println(samemodel.getId()+","+samemodel.getName());
////			targetMapper.insert(samemodel);
////		}
////		
////		
////		for(DataMoveTestModel difmodel :listtarget){
////			difmodel.setId(null);
////			targetMapper.insertSelective(difmodel);
////		}
////		
//		
//		
//	}
	

}

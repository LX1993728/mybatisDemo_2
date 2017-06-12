package test.lx.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import test.lx.mybatis.po.OrderCustom;
import test.lx.mybatis.po.Orders;
import test.lx.mybatis.po.User;

public class OrdersMapperCustomTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	// 创建工厂
	@Before
	public void init() throws IOException {
		// 配置文件（SqlMapConfig.xml）
		String resource = "SqlMapConfig.xml";
        
		//加载配置文件到输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//一对一查询使用resultType完成
	@Test
	public void testFindOrderUserList() throws Exception{
		SqlSession sqlSession  = sqlSessionFactory.openSession();
		//创建mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		// 调用方法
		List<OrderCustom> list = ordersMapperCustom.findOrderUserList();
		
		System.out.println(list);
	}
	
	//一对一查询使用resultMap完成
	@Test
	public void testFindOrderUserListResultMap() throws Exception{
		SqlSession sqlSession  = sqlSessionFactory.openSession();
		//创建mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		// 调用方法
		List<Orders> list = ordersMapperCustom.findOrderUserListResultMap();
		for (Orders orders : list) {
			System.out.println(orders.getUser().getUsername());
		}
		System.out.println(list);
	}
	
	//一对多查询使用resultMap
	@Test
	public void testFindOrderAndOrderdetails() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		//调用方法
		List<Orders> list = ordersMapperCustom.findOrderAndOrderdetails(); 
		for (Orders orders : list) {
			System.out.println(orders.getUser().getUsername()+"  "+orders.getOrderDetails().size());
		}
		System.out.println(list);
	}

	//一对多查询使用resultMap
	@Test
	public void testFindUserOrderDetail() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<User> list = ordersMapperCustom.findUserOrderDetail();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
    //一对一查询 延迟加载
	@Test
	public void testFindOrderUserListLazyLoading() throws Exception{
		SqlSession sqlSession  = sqlSessionFactory.openSession();
		//创建mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		// 调用方法
		List<Orders> list = ordersMapperCustom.findOrderUserListLazyLoading();
		
		//这里执行延迟加载，要发出SQL
		User user = list.get(0).getUser();
		System.out.println(user);
	}
}

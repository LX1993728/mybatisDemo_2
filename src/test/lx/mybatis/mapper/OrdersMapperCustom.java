package test.lx.mybatis.mapper;

import java.util.List;

import test.lx.mybatis.po.OrderCustom;
import test.lx.mybatis.po.Orders;
import test.lx.mybatis.po.User;

/**
 * 订单自定义的mapper接口
 * 
 * @author liuxun
 *
 */
public interface OrdersMapperCustom {
	// 一对一查询，查询订单关联查询用户，使用resultType
	public List<OrderCustom> findOrderUserList() throws Exception;

	// 一对一查询，查询订单关联查询用户，使用resultMap
	public List<Orders> findOrderUserListResultMap() throws Exception;

	// 一对一查询，查询订单延迟加载用户信息，使用resultMap
	public List<Orders> findOrderUserListLazyLoading() throws Exception;
	
	// 一对多查询，查询订单关联查询订单明细，使用resultMap
	public List<Orders> findOrderAndOrderdetails() throws Exception;
   
	// 一对多查询，查询订单关联查询订单明细以及商品信息，使用resultMap
	public List<User> findUserOrderDetail() throws Exception;
}

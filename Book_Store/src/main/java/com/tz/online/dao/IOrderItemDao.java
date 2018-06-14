package com.tz.online.dao;

public interface IOrderItemDao {
	/**
	 * 此接口无需定义方法,所有操作都是 OrderDao 进行级联操作
	 * 比如:保存订单时级联保存明细
	 * 查询订单时,迫切加载出明细
	 * 删除订单时,级联删除明细
	 * 不存在更新操作
	 */
}

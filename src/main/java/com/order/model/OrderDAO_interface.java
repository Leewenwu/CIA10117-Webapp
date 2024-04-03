package com.order.model;

import java.util.*;

public interface OrderDAO_interface {
	  public void insert(OrderVO ordVO);
      public void update(OrderVO ordVO);
      public void delete(Integer ordid);
      public OrderVO findByPrimaryKey(Integer ordid);
      public List<OrderVO> getAll();
}

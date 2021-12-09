package jdbcapp.impl;

import jdbcapp.model.Product;

public interface ProductInterface {
  public int insert(Product p);
  public int delete(Product p);
  public int update(Product p);
}

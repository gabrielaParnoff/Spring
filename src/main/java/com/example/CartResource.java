package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CartResource {
  
  @Autowired
  private CartRepository repository;

  @Autowired
  private ProductRepository products;
 
  @Autowired
  private CustomerRepository customers;
 
  public CartResource() {}

 
  @RequestMapping(value = "/Compras/{id}", method = RequestMethod.DELETE)
  public void removerCart(@PathVariable Long id) {
    this.repository.deleteById(id);
  }

 @RequestMapping(value ="/compras/" ,
  method = RequestMethod.POST)
  public Cart criarCart(@RequestBody Cart cart) {
    Product product = this.products.findById(cart.getProduct().getId()).get();
      Customer customer = this.customers.findById(cart.getCustomer().getId()).get();
        return this.repository.save(new Cart(product, customer));
  }

  @RequestMapping(value ="/compras/" , method = RequestMethod.PUT)
  public void alterarCompras(@PathVariable Long id, @RequestBody Cart produtoParam) {
     Cart compra = this.repository.findById(id).get();
     compra.setProduct(this.products.findById(produtoParam.getProduct().getId()).get());
       compra.setCustomer(this.customers.findById(produtoParam.getCustomer().getId()).get());
         this.repository.save(compra);
  }
 
@RequestMapping(value="/compras/finalizar", method= RequestMethod.POST)
public Map<String,String> finalizarcompras() {this.repository.deleteAll();
  Map<String,String> res = new HashMap<>();
  res.put("mensagem", "compra finalizada");
  return res;
}
}
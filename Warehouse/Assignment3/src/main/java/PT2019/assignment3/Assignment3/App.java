package PT2019.assignment3.Assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrderDetailBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrdersBusiness;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;
import PT2019.assignment3.Assignment3.model.Client;
import PT2019.assignment3.Assignment3.model.OrderDetail;
import PT2019.assignment3.Assignment3.model.Orders;
import PT2019.assignment3.Assignment3.model.Product;
import PT2019.assignment3.Assignment3.presentation.ClientController;
import PT2019.assignment3.Assignment3.presentation.ClientView;
import PT2019.assignment3.Assignment3.presentation.Controller;
import PT2019.assignment3.Assignment3.presentation.InsideController;
import PT2019.assignment3.Assignment3.presentation.InsideView;
import PT2019.assignment3.Assignment3.presentation.OrderController;
import PT2019.assignment3.Assignment3.presentation.OrderView;
import PT2019.assignment3.Assignment3.presentation.ProductController;
import PT2019.assignment3.Assignment3.presentation.ProductView;
import PT2019.assignment3.Assignment3.presentation.View;

/**
 * Hello world!
 *
 */
public class App 
{
	protected static final Logger LOGGER = Logger.getLogger(App.class.getName());
   /* public static void main( String[] args )
    {
        ClientBusiness clientBusiness = new ClientBusiness();
        Client firstClient = null;
        try {
        	firstClient = clientBusiness.findClientById(4);
        }catch(Exception ex) {
        	LOGGER.log(Level.INFO, ex.getMessage());
        }
        
       // ReflectionExample.retrieveProperties(firstClient);
      List<? extends Object> list = clientBusiness.selectAll();
    //   list = ReflectionExample.retrievePropertiesFromArray(list);
       System.out.println(list);
       int id = ReflectionExample.retrieveId(list) + 1;
       Client client = new Client(id, "Urcan Denisa", "str. Plopilor nr. 2A", "denisa_1272@yahoo.com", "0756277614");
       clientBusiness.delete(14);
       System.out.println(clientBusiness.selectAll());
        /*
        List<Client> list = clientBusiness.selectAll();
        System.out.println(list);
        clientBusiness.delete(1);
        list = clientBusiness.selectAll();
        System.out.println(list);
      
        list = clientBusiness.selectAll();
        System.out.println(list);
        client.setName("Urcan Denisa-Teodora");
        clientBusiness.updateClient(client);
        list = clientBusiness.selectAll();
        System.out.println(list);*/

	/*ProductBusiness productBusiness = new ProductBusiness();
        Product product = null;
        try {
        	product = productBusiness.findProductById(1);
        }catch(Exception ex) {
        	LOGGER.log(Level.INFO, ex.getMessage());
        }
        ReflectionExample.retrieveProperties(product);

        List<Product>list = productBusiness.selectAll();
        System.out.println(list);

        productBusiness.delete(2);
        list = productBusiness.selectAll();
        System.out.println(list);

        product = new Product(2, "Apple Iphone 8", 200, 3000);
        productBusiness.insertProduct(product);
        list = productBusiness.selectAll();
        System.out.println(list);

        product.setName("Apple Iphone 8s");
        productBusiness.updateProduct(product);
        list = productBusiness.selectAll();
        System.out.println(list);

    	OrdersBusiness orderBusiness = new OrdersBusiness();
    	   orderBusiness.insertOrder(new Orders(1, "Denisa"));
    	Orders order = null;
    	try {
    	order = orderBusiness.findOrderById(1);
    	} catch(Exception ex) {
    		LOGGER.log(Level.INFO, ex.getMessage());
    	}
    	ReflectionExample.retrieveProperties(order);
        List<Orders>list = orderBusiness.selectAll();
        System.out.println(list);

        orderBusiness.delete(1);
        list = orderBusiness.selectAll();
        System.out.println(list);

        order = new Orders(7, "Ana-Maria");
        orderBusiness.insertOrder(order);
        list = orderBusiness.selectAll();
        System.out.println(list);

        order.setName("ana- mmaria");
        orderBusiness.updateOrder(order);
        list = orderBusiness.selectAll();
        System.out.println(list);

    	OrderDetailBusiness orderDetail = new OrderDetailBusiness();
    	List<OrderDetail> list = new ArrayList<OrderDetail>();
    	try {
        	list = orderDetail.findOrderByIdO(1);
        	} catch(Exception ex) {
        		LOGGER.log(Level.INFO, ex.getMessage());
        	}
    	System.out.println(list);

    	list = orderDetail.selectAll();
    	System.out.println(list);

    	orderDetail.delete(1);
    	list = orderDetail.selectAll();
    	System.out.println(list);

    	orderDetail.insertOrderDetail(new OrderDetail(1, 2, 40));
    	list = orderDetail.selectAll();
    	System.out.println(list);

    	OrderDetail ord = new OrderDetail(1,2, 40);
    	ord.setQuantity(80);
    	orderDetail.updateOrder(ord);
    	list = orderDetail.selectAll();
    	System.out.println(list);*/

	/*ProductBusiness productBusiness = new ProductBusiness();
            Product product = null;
            try {
                product = productBusiness.findProductById(1);
            }catch(Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
            ReflectionExample.retrieveProperties(product);

            List<Product>list = productBusiness.selectAll();
            System.out.println(list);

            productBusiness.delete(2);
            list = productBusiness.selectAll();
            System.out.println(list);

            product = new Product(2, "Apple Iphone 8", 200, 3000);
            productBusiness.insertProduct(product);
            list = productBusiness.selectAll();
            System.out.println(list);

            product.setName("Apple Iphone 8s");
            productBusiness.updateProduct(product);
            list = productBusiness.selectAll();
            System.out.println(list);

            OrdersBusiness orderBusiness = new OrdersBusiness();
               orderBusiness.insertOrder(new Orders(1, "Denisa"));
            Orders order = null;
            try {
            order = orderBusiness.findOrderById(1);
            } catch(Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
            ReflectionExample.retrieveProperties(order);
            List<Orders>list = orderBusiness.selectAll();
            System.out.println(list);

            orderBusiness.delete(1);
            list = orderBusiness.selectAll();
            System.out.println(list);

            order = new Orders(7, "Ana-Maria");
            orderBusiness.insertOrder(order);
            list = orderBusiness.selectAll();
            System.out.println(list);

            order.setName("ana- mmaria");
            orderBusiness.updateOrder(order);
            list = orderBusiness.selectAll();
            System.out.println(list);

            OrderDetailBusiness orderDetail = new OrderDetailBusiness();
            List<OrderDetail> list = new ArrayList<OrderDetail>();
            try {
                list = orderDetail.findOrderByIdO(1);
                } catch(Exception ex) {
                    LOGGER.log(Level.INFO, ex.getMessage());
                }
            System.out.println(list);

            list = orderDetail.selectAll();
            System.out.println(list);

            orderDetail.delete(1);
            list = orderDetail.selectAll();
            System.out.println(list);

            orderDetail.insertOrderDetail(new OrderDetail(1, 2, 40));
            list = orderDetail.selectAll();
            System.out.println(list);

            OrderDetail ord = new OrderDetail(1,2, 40);
            ord.setQuantity(80);
            orderDetail.updateOrder(ord);
            list = orderDetail.selectAll();
            System.out.println(list);*/
	public static void main(String[] args) {
		
		InsideView view = new InsideView();
		ClientView addClientView = new ClientView();
		ProductView productView = new ProductView();
		ClientBusiness client = new ClientBusiness();
		OrdersBusiness ord = new OrdersBusiness();
		OrderDetailBusiness order = new OrderDetailBusiness();
		ProductBusiness prod = new ProductBusiness();
		OrderView orderView = new OrderView(client, prod);
		ClientController cl = new ClientController(addClientView, client);
		ProductController pr = new ProductController(productView, prod);
		OrderController or = new OrderController(orderView, ord, order);
		InsideController cont = new InsideController(view, addClientView, productView, orderView);		
		View mainView = new View(view);
		Controller controller = new Controller(mainView);
		mainView.setVisible(true);
	}
}

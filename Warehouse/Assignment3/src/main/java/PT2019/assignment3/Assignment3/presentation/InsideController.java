package PT2019.assignment3.Assignment3.presentation;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrderDetailBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrdersBusiness;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;
import PT2019.assignment3.Assignment3.model.OrderDetail;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class InsideController{
	private InsideView view;
	ClientView addClientView;
	ProductView productView;
	OrderView orderView;
	public InsideController(InsideView view, ClientView addClientView, ProductView productView, OrderView orderView) {
		this.view = view;
		this.productView = productView;
		this.addClientView = addClientView;
		this.orderView = orderView;
		view.addMouseListener(new MouseListenerr());
	}
	
	class MouseListenerr implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getX() + " " + e.getY());
			if(e.getX() >= 385 && e.getX() <= 541 && e.getY() >= 122 && e.getY() <= 414) {
				System.out.println("AICI"+ e.getX() + " " + e.getY());
				view.setVisible(false);
				addClientView.setVisible(true);
			}
			else if((e.getX() >= 133 && e.getX() <= 230 && e.getY() >= 260 && e.getY() <= 427) ||(e.getX() >= 546 && e.getX() <= 697 && e.getY() >= 227 && e.getY() <= 417)){
				System.out.println("AICI"+ e.getX() + " " + e.getY());
				view.setVisible(false);
				productView.setVisible(true);
			}
			else if(e.getX() >= 231 && e.getX() <= 384) {
				System.out.println("COS");
				view.setVisible(false);
				orderView.setVisible(true);
				
			}
			else if(e.getX() <= 116 && e.getX() >= 61) {
				Document document = new Document();
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("WareHouse.pdf"));
			         document.open();
			         OrdersBusiness ord = new OrdersBusiness();
			         OrderDetailBusiness or = new OrderDetailBusiness();
			        // document.add(new Paragraph(ord.selectAll().toString()));
			        // document.add(new Paragraph(or.selectAll().toString()));
			         List<OrderDetail> list = or.findOrderByIdO(0);
			         Iterator<OrderDetail>it = list.iterator();
			         int totalQuantity = 0;
			         int totalPrice = 0;
			         int ido = 0;
			         while(it.hasNext()) {
			        	 OrderDetail order = it.next();
			        	 	ido = order.getIdO();
			        	// document.add(new Paragraph(it.toString()));
			        	 totalQuantity += order.getQuantity();
			         }
			         document.add(new Paragraph("Client " + ido));
			         it = list.iterator();
			         while(it.hasNext()) {
			        	 	OrderDetail order = it.next();
			        	 	//ido = order.getIdO();
			        	 	int price = (int) (Math.random()*30 + 4);
				        	document.add(new Paragraph("product "+ order.getIdP()+ " quantity " + order.getQuantity() + " price/unit " + price));
				        	totalPrice += order.getQuantity()*price;
				         }
			         document.add(new Paragraph("Total quantity: " + totalQuantity + ", total price " + totalPrice ));
			       //  document.add(new Paragraph("Total price: " + price));
			         document.close();
			         writer.close();
			      } catch (DocumentException ex)
			      {
			         ex.printStackTrace();
			      } catch (FileNotFoundException ex)
			      {
			         ex.printStackTrace();
			      }
			}
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
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
		view.setVisible(true);

	}
}

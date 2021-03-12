package com.aitrich.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.reactive.mutiny.Mutiny;

import com.aitrich.customer.CustomerService;
import com.aitrich.domain.entity.Category;
import com.aitrich.domain.entity.OrderDetails;
import com.aitrich.domain.entity.PurchaseOrder;
import com.aitrich.domain.repository.OrderDetailsRepository;
import com.aitrich.domain.repository.OrderRepository;
import com.aitrich.product.ProductService;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Transactional
public class OrderServiceImpl implements OrderService {

	@Inject
	OrderRepository orderRepo;
	@Inject
	OrderDetailsRepository orderDetailsRepo;

	@Inject
	Mutiny.Session session;
	
	@Inject
	ProductService productService;
	
	@Inject
	CustomerService customerService;

	// Set<OrderDetails> orderDetails=new HashSet<OrderDetails>();

	@Override
	public Uni<PurchaseOrder> saveOrder(PurchaseOrder orderEntity) {
		// TODO Auto-generated method stub
		orderEntity.getOrderDetails().forEach(od -> {
			od.setOrder(orderEntity);
		});
		
		orderEntity.getOrderDetails().forEach(od -> {
			od.setProduct(productService.findProductById(od.getProduct().getId()).await().indefinitely());
		});
		
		orderEntity.setCustomer(customerService.findCustomerById(orderEntity.getCustomer().getId()).await().indefinitely());

		System.out.println(orderEntity);

		return orderRepo.persist(orderEntity).chain(orderRepo::flush).onItem().transform(ignore -> orderEntity);
	}

	@Override
	public Uni<Boolean> deleteOrderById(Long cid) {
		// TODO Auto-generated method stub
		return orderRepo.deleteById(cid).chain(orderDetailsRepo::flush).onItem().transform(ignore -> true);
	}

	@Override
	public Uni<PurchaseOrder> findOrderById(Long cid) {
		// TODO Auto-generated method stub
		return orderRepo.findById(cid);
	}

	@Override
	public Uni<List<PurchaseOrder>> findAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll().list();
	}

	@Override
	public Uni<Long> deleteOneOrderItem(long oId, long oDId,Set<OrderDetails> DetailsList) {
		// TODO Auto-generated method stub
		// orderRepo.flush().onItem().transform(ignore-> orderEntity);
		//System.out.println("zzzzzzzzzzzz"+DetailsList);
		//orderDetails=DetailsList;
		//Function<OrderEntity, Uni<? extends OrderEntity>> delete = entity -> {
			//System.out.println("1111111111111"+entity);
			// System.out.println("111111111111111111111111111111111111"+entity);
			// entity.setCategoryName(category.getCategoryName());
			// entity.getOrderDetails().removeIf(n -> (n.getId()==oDId));
//			for (Iterator<OrderDetails> iterator = this.entity.getOrderDetails().iterator(); iterator.hasNext();) {
//				OrderDetails od = iterator.next();
//				if (od.getId() == oDId) {
//					//od.setOrder(null);
//					entity.removeOrderDetail(od);
//					break;
//				}
//			OrderDetails orderDetails=find(entity, oDId);
//			entity.removeOrderDetail(orderDetails);
//			System.out.println("qqqqqqqqqqqqqqq"+entity);
//			entity.getOrderDetails().forEach(od -> {
//				od.setOrder(entity);
//				
//				
//			});
			
			
			//Set orderDetails=entity.getOrderDetails();
			//OrderEntity orderDetails=new OrderEntity();
			
			//orderDetails=entity.getOrderDetails();
			//Set<OrderDetails> orderDetailsList=find(orderDetails, oDId);
			//entity.getOrderDetails().removeIf(n -> (n.getId()==oDId));
			//session.merge(entity.getOrderDetails());
			//entity.getOrderDetails().clear();
			
//			OrderEntity orderEntity =new OrderEntity();
//			Set<OrderDetails> orderDetails=new HashSet<OrderDetails>();
//			orderEntity= findOrderById(oId).await().indefinitely();
//			orderDetails=orderEntity.getOrderDetails();
//			orderDetails.removeIf(n -> (n.getId()==oDId));
			
			//System.out.println("222222222222222"+orderEntity);
			//System.out.println("333333333333333"+entity);
			//entity.getOrderDetails().addAll(orderDetails);
			//System.out.println("44444444444444444444444"+entity);
		//	System.out.println("44444444444444444444444"+orderDetails);
			//orderDetails.forEach(od -> {
		//		System.out.println("oooooooooooooooooooooo"+od);
		//		entity.addOrderDetail(od);
		//	});
			
		//	System.out.println("55555555555555555"+entity);
		//	em.persist(entity);
			//em.flush();

			//return orderRepo.flush().onItem().transform(ignore -> entity);

		//};
		//return orderRepo.findById(oId).onItem().ifNotNull().transformToUni(delete);

		// return orderRepo.findById(null);

		// return }
		
		//orderRepo.
		return orderRepo.delete("id", oDId);
		
		//session.na
	}

	/*
	 * private Set<OrderDetails> find(Set<OrderDetails> orderDetails, long oDId) {
	 * // TODO Auto-generated method stub
	 * 
	 * // for (Iterator<OrderDetails> iterator =
	 * entity.getOrderDetails().iterator(); iterator.hasNext();) { // OrderDetails
	 * od = iterator.next(); // if (od.getId() == oDId) { // iterator.remove(); //
	 * return od; // } orderDetails.removeIf(n -> (n.getId()==oDId));
	 * Set<OrderDetails> orderDetailsList=new HashSet<OrderDetails>();
	 * orderDetailsList=orderDetails; // }
	 * System.out.println("qqqqqqqqqqqqqqqqqqqq"+orderDetailsList);
	 * 
	 * return orderDetailsList;
	 * 
	 * }
	 */
}

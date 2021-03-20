package com.aitrich.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.reactive.mutiny.Mutiny;

import com.aitrich.domain.entity.OrderDetails;
import com.aitrich.domain.entity.OrderSearch;
import com.aitrich.domain.entity.PurchaseOrder;
import com.aitrich.domain.repository.OrderRepository;
import com.aitrich.order.details.OrderDetailsService;
import com.aitrich.order.request.OrderRequest;
import com.aitrich.order.request.converter.OrderDetailsConverter;
import com.aitrich.order.request.converter.OrderEntityConverter;
import com.aitrich.order.search.converter.OrderEntityToOrderSearch;

import io.smallrye.mutiny.Uni;

@GraphQLApi
public class OrderResourceEndpoint {

	@Inject
	OrderDetailsService oderDetailsService;

	@Inject
	OrderService orderService;

	@Inject
	OrderEntityConverter orderEntityConverter;

	@Inject
	OrderDetailsConverter orderDetailsConverter;

	@Inject
	OrderEntityToOrderSearch orderEntityToOrderSearch;

	@Inject
	Mutiny.Session session;

	@Mutation
	public Uni<List<OrderSearch>> plceOrder(OrderRequest orderDto) throws InterruptedException, ExecutionException {
		PurchaseOrder orderEntity = orderEntityConverter.convert(orderDto);
		return orderService.saveOrder(orderEntity);
	}

	@Query
	public Uni<List<OrderSearch>> findAllOrders() {

		return orderService.findAllOrderFromOrderSearch();
	}

	@Query
	public Uni<List<OrderSearch>> findOrderById(long id) {

		return orderService.findOrderByOrderId(id);
	}
	
	@Query
	public Uni<List<OrderSearch>> findOrderByCustomerId(long id) {

		return orderService.findOrderByCustomerId(id);
	}

	@Mutation
	public Uni<Boolean> deleteOrderById(long oId) {
		return orderService.deleteOrderById(oId);
	}
	

	@Mutation
	@Transactional
	public Uni<PurchaseOrder> deleteOneOrderItem(long oId, long oDId) {

		// em.getTransaction().begin();
		Uni<PurchaseOrder> orderEntityUni = session.find(PurchaseOrder.class, oId);
		PurchaseOrder orderEntity = orderEntityUni.await().indefinitely();

		// session.detach(orderEntity);
//		orderEntity.removeOrderDetail(orderEntity.getOrderDetails().);
		// orderEntity.addOrderDetail(new OrderDetails());

		// orderEntity.addOrderDetail(new OrderDetails());
		// orderEntity.removeOrderDetail();
		// orderEntity.getOrderDetails().removeIf(n -> (n.getId()==oDId));
		/*
		 * session.merge(orderEntity);
		 * 
		 * orderEntity.getOrderDetails().forEach(od -> { od.setOrder(orderEntity); });
		 * 
		 * session.merge(orderEntity.getOrderDetails());
		 */

		// session.flush();
		// session.
		// orderEntity.removeOrderDetail();
		// orderEntity.addOrderDetail(new OrderDetails());

		// session.refresh(orderEntity);
		// session.merge(orderEntity.getOrderDetails());
		// return session.persist(orderEntity.getOrderDetails()).chain(session ::
		// flush).onItem().transform(ignore -> orderEntity);

		// ses
//		OrderEntity orderEntity =new OrderEntity();
//		Set<OrderDetails> orderDetails=new HashSet<OrderDetails>();
//		orderEntity= orderRepo.findById(oId).await().indefinitely();
//		orderDetails=orderEntity.getOrderDetails();
//		orderDetails.removeIf(n -> (n.getId()==oDId));
//		 System.out.println("pppppppppppppppppp"+orderDetails);
		// return Uni.createFrom().item(orderEntity);

		orderEntity.getOrderDetails().forEach(od -> {
			if (od.getId() == oDId) {
				// od.setOrder(null);
				// orderEntity.removeOrderDetail(od);
				od.getOrder().removeOrderDetail(od);
				// session.remove(od);
			}
		});

		session.persist(orderEntity);

//		for (Iterator<OrderDetails> iterator = orderEntity.getOrderDetails().iterator(); iterator.hasNext();) {
//			OrderDetails od = iterator.next();
//			if (od.getId() == oDId) {
//				// od.setOrder(null);
//				od.setOrder(null);
//				//System.out.println(od);
//				//orderEntity.removeOrderDetail(od);
//				iterator.remove();
//				break;
//			}
//		}
		// session.merge(orderEntity);
		/*
		 * session.clear();
		 * 
		 * Uni<OrderEntity> orderEntityUniObj=session.find(OrderEntity.class, oId);
		 * OrderEntity orderEntityOBj=orderEntityUniObj.await().indefinitely();
		 * //orderEntityOBj.getOrderDetails().clear();
		 * System.out.println("1111111"+orderEntityOBj);
		 * System.out.println("22222222"+orderEntity);
		 * orderEntityOBj.getOrderDetails().removeIf(n -> (n.getId()==oDId));
		 * System.out.println("33333333"+orderEntityOBj);
		 * orderEntity.getOrderDetails().forEach(od -> {
		 * 
		 * orderEntity.addOrderDetail(new
		 * OrderDetails(0,od.getProduct(),od.getQuantity())); });
		 * 
		 * System.out.println("444444444"+orderEntity);
		 */

		// return orderService.deleteOrderById(oId);

		// return orderService.saveOrder(orderEntity);
		// return orderService.deleteOneOrderItem(oId, oDId,null);

		// return session.persist(orderEntity).chain(session ::
		// flush).onItem().transform(ignore -> orderEntity);

		return session.flush().onItem().transform(ignore -> orderEntity);

		// return Uni.createFrom().item(orderEntity);

		// Uni<Integer> OrderDetails=session.createNativeQuery("DELETE FROM OrderDetails
		// od where od.id= $1",OrderDetails.class).setParameter(0,
		// oDId).executeUpdate();

		// Uni<Integer> OrderDetails=session.createNativeQuery("DELETE FROM OrderDetails
		// od where od.id= ?")
		// .setParameter(1, oDId).executeUpdate();

		// return OrderDetails;

		// return session.merge(orderEntity).chain(session ::
		// flush).onItem().transform(ignore -> orderEntity);
	}


}

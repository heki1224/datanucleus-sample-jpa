package sample.datanucleus_sample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sample.datanucleus_sample.model.MyClass;

@Repository
public class ProductDao {

	@PersistenceContext(unitName = "transactions-optional")
	private EntityManager entityManager;

	public List<MyClass> loadProducts() {
		Query query = entityManager.createQuery("select m from MyClass m");
		List result = (List<MyClass>) query.getResultList();
		return result;
	}

	@Transactional(rollbackFor = Exception.class)
	public MyClass create(MyClass input) {
		entityManager.persist(input);
		return input;
	}

	@Transactional(rollbackFor = Exception.class)
	public MyClass save(MyClass input) {
		entityManager.persist(input);
		return input;
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(MyClass input) {
		MyClass find = entityManager.find(MyClass.class, input);
		if (find != null) {
			entityManager.remove(find);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteAll() {
		Query query = entityManager.createQuery("select m from MyClass m");
		List result = (List<MyClass>) query.getResultList();
		entityManager.remove(result);
	}
}

package sample.datanucleus_sample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sample.datanucleus_sample.model.User;

@Repository
public class UserDao {

	private static final Log LOG = LogFactory.getLog(UserDao.class);

	@PersistenceContext(unitName = "transactions-optional")
	private EntityManager entityManager;

	/**
	 * 1件取得
	 * 
	 * @param id
	 * @return managed User
	 */
	public User find(Long id) {
		User result = null;
		result = entityManager.find(User.class, id);
		return result;
	}

	/**
	 * 全件取得
	 * 
	 * @return managed User List
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Query query = entityManager.createQuery("select m from User m");
		List<User> result = (List<User>) query.getResultList();
		if (result == null || result.size() == 0) {
			return null;
		}
		return result;
	}

	/**
	 * 新規作成および更新
	 * 
	 * @param input
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public User save(User input) {
		entityManager.merge(input);
		return input;
	}

	/**
	 * 新規作成および更新 （テスト用）
	 * 
	 * @param input
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public User saveThrowException(User input) {
		entityManager.merge(input);
		if (true) {
			throw new RuntimeException();
		}
		return input;
	}

	/**
	 * 削除
	 * 
	 * @param input
	 */
	@Transactional(rollbackFor = Exception.class)
	public void delete(User input) {
		User target = null;
		target = entityManager.find(User.class, input.getId());
		entityManager.remove(target);
	}

	/**
	 * 削除
	 * 
	 * @param input
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteAll() {
		Query query = entityManager.createQuery("select m from User m");
		List<User> target = (List<User>) query.getResultList();
		if (target != null && target.size() > 0) {
			entityManager.remove(target);
		}
	}
}

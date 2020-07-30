package group.msg.at.cloud.cloudtrain.adapter.persistence.jpa.repository;

import group.msg.at.cloud.common.persistence.jpa.repository.AbstractGenericRepository;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Concrete Implementation of an {@link AbstractGenericRepository}.
 * <p>
 * Subclassing is required to bind the capabilities of {@code AbstractGenericRepository} to a local stateless
 * session bean and to bind the {@code AbstractGenericRepository} to the actual {@code EntityManager} known to this
 * application.
 * </p>
 *
 * @author Michael Theis (mtheis@msg.group)
 * @version 1.0
 * @since release 1.0
 */
@Dependent
public class GenericRepository extends AbstractGenericRepository {

    /**
     * Actual persistence context of this application
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @see group.msg.at.cloud.common.persistence.jpa.repository.AbstractGenericRepository#getEntityManager()
     */
    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
}

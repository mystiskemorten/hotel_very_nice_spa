import java.util.List;
import java.util.Optional;

public interface DatabaseInterface {

    <T> PreparedStatement<T> createPreparedStatement(String query,  Class<T> resultClass);
    void persist(Object entity);
    <T> Optional<T> find(long id, Class<T> entityClass);
    Object runQuery(String query);

    interface PreparedStatement<T> {
        PreparedStatement<T> setParameter(int paramNum, Object param);
        List<T> getResultList();
        Object getSingleResult();
        int executeUpdate();
    }

}

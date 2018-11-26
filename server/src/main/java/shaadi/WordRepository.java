// $Id\$
package shaadi;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word, Long>{

	@Query("select w from Word w where w.value LIKE '%hello%'")
	List<Word> findAllWithHello();

}

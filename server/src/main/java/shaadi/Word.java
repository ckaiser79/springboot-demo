// $Id\$
package shaadi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Word {

	@Id
	@GeneratedValue
	private Long id;

	private String value;

}

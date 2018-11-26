// $Id\$
package shaadi;

import java.util.LinkedList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("access to database")
public class EchoWithListController {

	private List<String> data = new LinkedList();

	/**
	 * save a word in the database using a http connection
	 */
	@ApiOperation("save a new word in a list")
	@PostMapping("/api/words/{word}")
	public void saveWord(@PathVariable("word") String word) {
		data.add(word);
	}

	@ApiOperation("returns all records from the list")
	@GetMapping("/api/words")
	public String[] getAllWords() {
		String[] r = new String[data.size()];
		r = data.toArray(r);
		return r;
	}

}

// $Id\$
package shaadi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("access to database")
public class EchoWithDbController {

	private final WordRepository wordRepository;

	@Autowired
	public EchoWithDbController(final WordRepository wordRepository) {
		this.wordRepository = wordRepository;
	}

	/**
	 * save a word in the database using a http connection
	 */
	@ApiOperation("save a new word in our database")
	@PostMapping("/api/db/words/{word}")
	public void saveWord(@PathVariable("word") String word) {
		Word w = new Word();
		w.setValue(word);
		wordRepository.save(w);
	}

	@ApiOperation("returns all records from the datbase")
	@GetMapping("/api/db/words")
	public Iterable<Word> getAllWords() {
		final Iterable<Word> all = wordRepository.findAll();
		return all;
	}

}

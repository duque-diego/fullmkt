package app.fullmkt.repository;

import java.util.List;

import app.fullmkt.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

//	List<Produto> findByLastName(String lastName);

	Produto findById(long id);
}

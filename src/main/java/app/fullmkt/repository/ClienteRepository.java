package app.fullmkt.repository;

import app.fullmkt.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	Cliente findById(long id);
	Cliente findByEmail(String email);
}

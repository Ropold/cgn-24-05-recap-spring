package ropold.cgn2405recapspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ropold.cgn2405recapspring.model.TodoModel;

public interface TodoRepo extends MongoRepository<TodoModel, String> {
}

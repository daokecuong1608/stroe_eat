package sv.cuong.store_eat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.cuong.store_eat.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

package kamenev.dao;

/**
 * Интерфейс ДАО (он же репозиторий в терминах Spring расширяет интерфейс JpaRepository
 * Он представляет набор стандартных методов (findBy, Save, DeleteBy, etc) для работы с БД
 * Если понадобится специфичный метод, его можно создать и JpaRepo поможет соответственно названию.
 */

import kamenev.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {
}

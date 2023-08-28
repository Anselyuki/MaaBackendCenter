package plus.maa.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import plus.maa.backend.repository.entity.Copilot;

import java.util.Optional;

/**
 * @author LoMu
 * Date  2022-12-27 10:28
 */

public interface CopilotRepository extends MongoRepository<Copilot, String> {

    Page<Copilot> findAllByDeleteIsFalse(Pageable pageable);

    Optional<Copilot> findFirstByOrderByCopilotIdDesc();

    Optional<Copilot> findByCopilotIdAndDeleteIsFalse(Long copilotId);

    Optional<Copilot> findByCopilotId(Long copilotId);

    boolean existsCopilotsByCopilotId(Long copilotId);

}

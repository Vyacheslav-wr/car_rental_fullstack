package by.salei.rental.service;

import by.salei.rental.entity.Condition;
import by.salei.rental.repo.ConditionRepository;
import by.salei.rental.service.api.ConditionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConditionServiceImpl extends BaseServiceImpl<Condition, ConditionRepository> implements ConditionService {

    private final ConditionRepository conditionRepository;
    @Override
    public ConditionRepository getDefaultRepo() {
        return conditionRepository;
    }
}

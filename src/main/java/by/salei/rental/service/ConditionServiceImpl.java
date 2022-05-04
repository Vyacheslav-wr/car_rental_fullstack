package by.salei.rental.service;

import by.salei.rental.entity.Condition;
import by.salei.rental.repo.ConditionRepository;
import by.salei.rental.service.api.ConditionService;
import org.springframework.stereotype.Service;

@Service
public class ConditionServiceImpl extends BaseServiceImpl<Condition, ConditionRepository> implements ConditionService {
}

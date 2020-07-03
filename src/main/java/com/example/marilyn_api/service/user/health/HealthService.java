package com.example.marilyn_api.service.user.health;

import com.example.marilyn_api.Domain.user.health.Health;
import com.example.marilyn_api.repository.user.health.HealthRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthService implements Iservice<Health,String> {
    private static HealthService healthService;

    @Autowired
    private HealthRep healthRep;

    public HealthService getHealthService() {
        if (healthService == null) {
            healthService = new HealthService();
        }
        return healthService;
    }

    @Override
    public Health create(Health health) {
        return healthRep.save(health);
    }

    @Override
    public Health update(Health health) {
        Health health1 = get(health.getId());
        if (health1 != null) {
            delete(health1.getId());
            return create(health);
        }
        return null;
    }

    @Override
    public Health read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Health health1 = get(id);
        if (health1 != null) {
            delete(health1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Health> readAll() {
        return healthRep.findAll();
    }

    @Override
    public Health get(String id) {
        Optional<Health> healthOptional = healthRep.findById(id);
        return healthOptional.orElse(null);
    }

    @Override
    public List<Health> readAllOf(String id) {
        return null;
    }
}

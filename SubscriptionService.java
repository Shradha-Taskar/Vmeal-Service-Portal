package com.project.vmeal.Service;

import com.project.vmeal.Entity.Subscription;
import com.project.vmeal.Repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    // Create/Add new Subscription
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    // Get all Subscriptions
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    // Get Subscription by ID
    public Optional<Subscription> getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id);
    }

    // Update Subscription
    public Subscription updateSubscription(Long id, Subscription subscriptionDetails) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found with id: " + id));

        subscription.setCustomerName(subscriptionDetails.getCustomerName());
        subscription.setMealName(subscriptionDetails.getMealName());
        subscription.setDurationDays(subscriptionDetails.getDurationDays());
        subscription.setPrice(subscriptionDetails.getPrice());
        subscription.setStartDate(subscriptionDetails.getStartDate());

        return subscriptionRepository.save(subscription);
    }

    // Delete Subscription
    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}

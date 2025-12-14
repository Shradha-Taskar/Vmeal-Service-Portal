package com.project.vmeal.Controller;

import com.project.vmeal.Entity.Subscription;
import com.project.vmeal.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "*")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    // Create/Add new Subscription
    @PostMapping("/add")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    // Get all Subscriptions
    @GetMapping("/all")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    // Get Subscription by ID
    @GetMapping("/{id}")
    public Optional<Subscription> getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    // Update Subscription
    @PutMapping("/update/{id}")
    public Subscription updateSubscription(@PathVariable Long id, @RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(id, subscription);
    }

    // Delete Subscription
    @DeleteMapping("/delete/{id}")
    public String deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return "Subscription deleted with id: " + id;
    }
}
